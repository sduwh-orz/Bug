package cn.edu.sdu.orz.bug.service;

import cn.edu.sdu.orz.bug.dto.BugDTO;
import cn.edu.sdu.orz.bug.entity.*;
import cn.edu.sdu.orz.bug.entity.Module;
import cn.edu.sdu.orz.bug.repository.*;
import cn.edu.sdu.orz.bug.utils.Utils;
import cn.edu.sdu.orz.bug.vo.BugQueryVO;
import cn.edu.sdu.orz.bug.vo.BugUpdateVO;
import cn.edu.sdu.orz.bug.vo.BugVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;
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

    public Page<BugDTO> query(BugQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private BugDTO toDTO(Bug original) {
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
}
