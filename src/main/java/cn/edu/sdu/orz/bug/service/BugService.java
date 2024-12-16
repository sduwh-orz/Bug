package cn.edu.sdu.orz.bug.service;

import cn.edu.sdu.orz.bug.dto.BugDTO;
import cn.edu.sdu.orz.bug.entity.*;
import cn.edu.sdu.orz.bug.entity.Module;
import cn.edu.sdu.orz.bug.repository.*;
import cn.edu.sdu.orz.bug.utils.Utils;
import cn.edu.sdu.orz.bug.vo.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static cn.edu.sdu.orz.bug.utils.Utils.getNullPropertyNames;

@Service
public class BugService {

    @Autowired
    private BugRepository bugRepository;

    @Autowired
    private BugRecordRepository bugRecordRepository;

    @Autowired
    private BugGradeRepository bugGradeRepository;

    @Autowired
    private BugStatusRepository bugStatusRepository;

    @Autowired
    private BugRecordTypeRepository bugRecordTypeRepository;

    @Autowired
    private BugSolveTypeRepository bugSolveTypeRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private FeatureService featureService;

    public Map<String, Object> search(BugQueryVO vO) {
        Bug example = new Bug();
        BeanUtils.copyProperties(vO, example);

        if (vO.getProjectId() != null) {
            Feature featureExample = getFeatureExample(vO);
            example.setFeature(featureExample);
        }

        if (vO.getReporter() != null) {
            User reporterExample = new User();
            reporterExample.setId(vO.getReporter());
            example.setReporter(reporterExample);
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        return Utils.pagination(
                vO.getSize(),
                vO.getPage(),
                pageable -> bugRepository.findAll(Example.of(example, matcher), pageable),
                this::toDTO
        );
    }

    public BugDTO getById(String id) {
        Bug original = bugRepository.findById(id).orElse(null);
        return toDTO(original);
    }

    public boolean create(BugCreateVO vO, HttpSession session) {
        User user = userService.getLoggedInUser(session);
        if (user == null)
            return false;
        try {
            Bug bean = new Bug();
            BeanUtils.copyProperties(vO, bean);
            bean.setId(newID());
            bean.setGrade(bugGradeRepository.findById(vO.getGrade()).orElseThrow());
            bean.setFeature(featureService.requireOne(vO.getFeature()));
            bean.setStatus(bugStatusRepository.findByName("开放中").orElseThrow());
            bean.setCreated(new Timestamp(System.currentTimeMillis()));
            bean.setReporter(user);
            bugRepository.save(bean);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean modify(BugVO vO, HttpSession session) {
        User user = userService.getLoggedInUser(session);
        if (user == null)
            return false;
        try {
            Bug bug = requireOne(vO.getId());
            BugRecord record = new BugRecord();
            BugStatus after = bug.getStatus();
            if (vO.getStatus() != null)
                after = bugStatusRepository.findById(vO.getStatus()).orElseThrow();
            BugSolveType solveType = null;
            if (vO.getSolveType() != null)
                solveType = bugSolveTypeRepository.findById(vO.getSolveType()).orElseThrow();
            Timestamp time = new Timestamp(System.currentTimeMillis());

            record.setId(newID());
            record.setBug(bug);
            record.setType(bugRecordTypeRepository.findByName("编辑问题").orElseThrow());
            record.setPrevious(bug.getStatus());
            record.setAfter(after);
            record.setSolveType(solveType);
            record.setComment(vO.getComment() != null ? vO.getComment() : "");
            record.setUser(user);
            record.setTime(time);
            bugRecordRepository.save(record);

            BeanUtils.copyProperties(vO, bug, getNullPropertyNames(vO));
            if (vO.getGrade() != null)
                bug.setGrade(bugGradeRepository.findById(vO.getGrade()).orElseThrow());
            String feature = vO.getFeature();
            if (feature != null)
                bug.setFeature(featureService.requireOne(vO.getFeature()));
            bug.setStatus(after);
            bug.setSolveType(solveType);
            bug.setModified(time);
            bug.setReporter(user);
            bugRepository.save(bug);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Map<String, Object> stats(String projectId) {
        if (projectId == null)
            return null;
        List<Bug> bugs = bugRepository.findByFeature_Module_Project_Id(projectId);
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> grade = bugGradeRepository.findAll().stream()
                .collect(Collectors.toMap(BugGrade::getName, k -> 0));
        grade.putAll(bugs.stream().collect(Collectors.groupingBy(
                bug -> bug.getGrade().getName(),
                Collectors.counting()
        )));
        result.put("grade", grade);
        Map<String, Object> status = bugStatusRepository.findAll().stream()
                .collect(Collectors.toMap(BugStatus::getName, k -> 0));
        status.putAll(bugs.stream().collect(Collectors.groupingBy(
                bug -> bug.getStatus().getName(),
                Collectors.counting()
        )));
        result.put("status", status);
        result.put("developers", bugs.stream().collect(Collectors.groupingBy(
                bug -> bug.getFeature().getOwner().getRealName(),
                Collectors.counting()
        )));
        result.put("reporters", bugs.stream().collect(Collectors.groupingBy(
                bug -> bug.getReporter().getRealName(),
                Collectors.counting()
        )));
        return result;
    }

    private static Feature getFeatureExample(BugQueryVO vO) {
        Feature featureExample = new Feature();
        Module moduleExample = new Module();
        Project projectExample = new Project();
        projectExample.setId(vO.getProjectId());

        moduleExample.setProject(projectExample);
        if (vO.getModule() != null)
            moduleExample.setId(vO.getModule());

        featureExample.setModule(moduleExample);
        if (vO.getFeature() != null)
            featureExample.setId(vO.getFeature());

        if (vO.getDeveloper() != null) {
            User ownerExample = new User();
            ownerExample.setId(vO.getDeveloper());
            featureExample.setOwner(ownerExample);
        }
        return featureExample;
    }

    private BugDTO toDTO(Bug original) {
        if (original == null)
            return null;
        BugDTO bean = new BugDTO();
        BeanUtils.copyProperties(original, bean);
        bean.setFeature(original.getFeature());
        bean.setGrade(original.getGrade());
        bean.setStatus(original.getStatus());
        bean.setSolveType(original.getSolveType());
        return bean;
    }

    private Bug requireOne(String id) {
        return bugRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    private String newID() {
        while (true) {
            String id = Utils.newRandomID();
            if (!bugRepository.existsById(id)) {
                return id;
            }
        }
    }
}
