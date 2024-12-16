package cn.edu.sdu.orz.bug.service;

import cn.edu.sdu.orz.bug.dto.BugDTO;
import cn.edu.sdu.orz.bug.entity.*;
import cn.edu.sdu.orz.bug.entity.Module;
import cn.edu.sdu.orz.bug.repository.*;
import cn.edu.sdu.orz.bug.vo.BugQueryVO;
import cn.edu.sdu.orz.bug.vo.BugUpdateVO;
import cn.edu.sdu.orz.bug.vo.BugVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BugService {

    @Autowired
    private BugRepository bugRepository;

    public String save(BugVO vO) {
        Bug bean = new Bug();
        BeanUtils.copyProperties(vO, bean);
        bean = bugRepository.save(bean);
        return bean.getId();
    }

    public void delete(String id) {
        bugRepository.deleteById(id);
    }

    public void update(String id, BugUpdateVO vO) {
        Bug bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        bugRepository.save(bean);
    }

    public BugDTO getById(String id) {
        Bug original = requireOne(id);
        return toDTO(original);
    }

    public List<BugDTO> search(
            String projectId,
            String name,
            Integer grade,
            String module,
            String feature,
            String owner,
            String reporter,
            Integer status,
            Integer solveType
    ) {
        Bug example = new Bug();

        if (projectId != null) {
            Feature featureExample = new Feature();
            Module moduleExample = new Module();
            Project projectExample = new Project();
            projectExample.setId(projectId);

            moduleExample.setProject(projectExample);
            if (module != null)
                moduleExample.setId(module);

            featureExample.setModule(moduleExample);
            if (feature != null)
                featureExample.setId(feature);

            if (owner != null) {
                User ownerExample = new User();
                ownerExample.setId(owner);
                featureExample.setOwner(ownerExample);
            }
            example.setFeature(featureExample);
        }

        if (reporter != null) {
            User reporterExample = new User();
            reporterExample.setId(reporter);
            example.setReporter(reporterExample);
        }

        example.setName(name);

        BugGrade gradeExample = new BugGrade();
        gradeExample.setId(grade);
        example.setGrade(gradeExample);

        BugStatus statusExample = new BugStatus();
        statusExample.setId(status);
        example.setStatus(statusExample);

        BugSolveType solveTypeExample = new BugSolveType();
        solveTypeExample.setId(solveType);
        example.setSolveType(solveTypeExample);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
        return bugRepository.findAll(Example.of(example, matcher)).stream().map(this::toDTO).toList();
    }

    public Page<BugDTO> query(BugQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private BugDTO toDTO(Bug original) {
        BugDTO bean = new BugDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Bug requireOne(String id) {
        return bugRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
