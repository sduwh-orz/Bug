package cn.edu.sdu.orz.bug.service;

import cn.edu.sdu.orz.bug.dto.BugDTO;
import cn.edu.sdu.orz.bug.entity.Bug;
import cn.edu.sdu.orz.bug.repository.BugRepository;
import cn.edu.sdu.orz.bug.vo.BugQueryVO;
import cn.edu.sdu.orz.bug.vo.BugUpdateVO;
import cn.edu.sdu.orz.bug.vo.BugVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Bug> list(String projectId, String name, Integer grade) {
        return bugRepository.findByFeature_Module_Project_IdAndNameContainingIgnoreCaseAndGrade_IdNotNullOrGrade_Id(
                projectId, name, grade
        );
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
