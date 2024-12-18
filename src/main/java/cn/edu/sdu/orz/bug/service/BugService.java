package cn.edu.sdu.orz.bug.service;

import cn.edu.sdu.orz.bug.dto.BugDTO;
import cn.edu.sdu.orz.bug.dto.StatsDTO;
import cn.edu.sdu.orz.bug.dto.TypeDTO;
import cn.edu.sdu.orz.bug.entity.Module;
import cn.edu.sdu.orz.bug.entity.*;
import cn.edu.sdu.orz.bug.repository.*;
import cn.edu.sdu.orz.bug.utils.Utils;
import cn.edu.sdu.orz.bug.vo.BugCreateVO;
import cn.edu.sdu.orz.bug.vo.BugQueryVO;
import cn.edu.sdu.orz.bug.vo.BugUpdateVO;
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
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

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

        if (vO.getId() != null) {
            Feature featureExample = getFeatureExample(vO);
            example.setFeature(featureExample);
        }

        if (vO.getName() != null)
            example.setName(vO.getName());
        if (vO.getGrade() != null) {
            BugGrade gradeExample = new BugGrade();
            gradeExample.setId(vO.getGrade());
            example.setGrade(gradeExample);
        }
        if (vO.getStatus() != null) {
            BugStatus statusExample = new BugStatus();
            statusExample.setId(vO.getStatus());
            example.setStatus(statusExample);
        }
        if (vO.getSolveType() != null) {
            BugSolveType solveTypeExample = new BugSolveType();
            solveTypeExample.setId(vO.getSolveType());
            example.setSolveType(solveTypeExample);
        }

        if (vO.getReporter() != null) {
            User reporterExample = new User();
            reporterExample.setId(vO.getReporter());
            example.setReporter(reporterExample);
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", contains().ignoreCase());

        return Utils.pagination(
                vO.getPage(),
                vO.getSize(),
                pageable -> bugRepository.findAll(Example.of(example, matcher), pageable),
                BugDTO::toDTO
        );
    }

    private static Feature getFeatureExample(BugQueryVO vO) {
        Feature featureExample = new Feature();
        Module moduleExample = new Module();
        Project projectExample = new Project();

        if (vO.getFeature() != null) {
            featureExample.setId(vO.getFeature());
        } else if (vO.getModule() != null) {
            moduleExample.setId(vO.getModule());
            featureExample.setModule(moduleExample);
        } else {
            projectExample.setId(vO.getId());
            featureExample.setModule(moduleExample);
            moduleExample.setProject(projectExample);
        }


        if (vO.getDeveloper() != null) {
            User ownerExample = new User();
            ownerExample.setId(vO.getDeveloper());
            featureExample.setOwner(ownerExample);
        }
        return featureExample;
    }

    public BugDTO getById(String id) {
        Bug original = bugRepository.findById(id).orElse(null);
        return BugDTO.toDTO(original);
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
            bean.setSolveType(bugSolveTypeRepository.findByName("未解决").orElseThrow());
            bean.setCreated(new Timestamp(System.currentTimeMillis()));
            bean.setReporter(user);
            bugRepository.save(bean);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean modify(BugUpdateVO vO, HttpSession session) {
        User user = userService.getLoggedInUser(session);
        if (user == null)
            return false;
        try {
            Bug bug = requireOne(vO.getId());
            BugStatus after = bug.getStatus();
            if (vO.getStatus() != null)
                after = bugStatusRepository.findById(vO.getStatus()).orElseThrow();
            BugSolveType solveType = null;
            if (vO.getSolveType() != null)
                solveType = bugSolveTypeRepository.findById(vO.getSolveType()).orElseThrow();
            Timestamp time = new Timestamp(System.currentTimeMillis());
            BugRecord record = new BugRecord(
                    newID(), bug, bugRecordTypeRepository.findByName("编辑问题").orElseThrow(),
                    bug.getStatus(), after, solveType, vO.getComment() != null ? vO.getComment() : "", user, time
            );
            bugRecordRepository.save(record);
            updateBug(vO, bug, after, solveType, time);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean solve(BugUpdateVO vO, HttpSession session) {
        User user = userService.getLoggedInUser(session);
        if (user == null)
            return false;
        try {
            Bug bug = requireOne(vO.getId());
            BugStatus after = bugStatusRepository.findByName("已解决").orElseThrow();
            BugSolveType solveType = bugSolveTypeRepository.findById(vO.getSolveType()).orElseThrow();
            Timestamp time = new Timestamp(System.currentTimeMillis());
            BugRecord record = new BugRecord(
                    newID(), bug, bugRecordTypeRepository.findByName("解决问题").orElseThrow(),
                    bug.getStatus(), after, solveType, vO.getComment(), user, time
            );
            bugRecordRepository.save(record);
            updateBug(vO, bug, after, solveType, time);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean close(BugUpdateVO vO, HttpSession session) {
        User user = userService.getLoggedInUser(session);
        if (user == null)
            return false;
        try {
            Bug bug = requireOne(vO.getId());
            BugStatus after = bugStatusRepository.findByName("已关闭").orElseThrow();
            Timestamp time = new Timestamp(System.currentTimeMillis());
            BugRecord record = new BugRecord(
                    newID(), bug, bugRecordTypeRepository.findByName("关闭问题").orElseThrow(),
                    bug.getStatus(), after, null, vO.getComment(), user, time
            );
            bugRecordRepository.save(record);
            updateBug(vO, bug, after, bug.getSolveType(), time);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean comment(BugUpdateVO vO, HttpSession session) {
        User user = userService.getLoggedInUser(session);
        if (user == null)
            return false;
        try {
            Bug bug = requireOne(vO.getId());
            BugStatus after = bug.getStatus();
            Timestamp time = new Timestamp(System.currentTimeMillis());
            BugRecord record = new BugRecord(
                    newID(), bug, bugRecordTypeRepository.findByName("写备注").orElseThrow(),
                    bug.getStatus(), after, null, vO.getComment(), user, time
            );
            bugRecordRepository.save(record);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void updateBug(BugUpdateVO vO, Bug bug, BugStatus after, BugSolveType solveType,
                           Timestamp time) {
        BeanUtils.copyProperties(vO, bug, getNullPropertyNames(vO));
        if (vO.getGrade() != null)
            bug.setGrade(bugGradeRepository.findById(vO.getGrade()).orElseThrow());
        String feature = vO.getFeature();
        if (feature != null)
            bug.setFeature(featureService.requireOne(vO.getFeature()));
        bug.setStatus(after);
        bug.setSolveType(solveType);
        bug.setModified(time);
        bugRepository.save(bug);
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
        result.put("grade", grade.entrySet().stream().map(entry ->
                new StatsDTO(entry.getKey(), entry.getValue().toString())
        ).collect(Collectors.toList()));
        Map<String, Object> status = bugStatusRepository.findAll().stream()
                .collect(Collectors.toMap(BugStatus::getName, k -> 0));
        status.putAll(bugs.stream().collect(Collectors.groupingBy(
                bug -> bug.getStatus().getName(),
                Collectors.counting()
        )));
        result.put("status", status.entrySet().stream().map(entry ->
                new StatsDTO(entry.getKey(), entry.getValue().toString())
        ).collect(Collectors.toList()));
        result.put("developers", bugs.stream().collect(Collectors.groupingBy(
                bug -> bug.getFeature().getOwner().getRealName(),
                Collectors.counting()
        )).entrySet().stream().map(entry ->
                new StatsDTO(entry.getKey(), entry.getValue().toString())
        ).collect(Collectors.toList()));
        result.put("reporters", bugs.stream().collect(Collectors.groupingBy(
                bug -> bug.getReporter().getRealName(),
                Collectors.counting()
        )).entrySet().stream().map(entry ->
                new StatsDTO(entry.getKey(), entry.getValue().toString())
        ).collect(Collectors.toList()));
        return result;
    }

    public List<TypeDTO> getBugGrades() {
        return bugGradeRepository.findAll().stream().map(TypeDTO::toDTO).toList();
    }

    public List<TypeDTO> getBugRecordTypes() {
        return bugRecordTypeRepository.findAll().stream().map(TypeDTO::toDTO).toList();
    }

    public List<TypeDTO> getBugSolveTypes() {
        return bugSolveTypeRepository.findAll().stream().map(TypeDTO::toDTO).toList();
    }

    public List<TypeDTO> getBugStatus() {
        return bugStatusRepository.findAll().stream().map(TypeDTO::toDTO).toList();
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
