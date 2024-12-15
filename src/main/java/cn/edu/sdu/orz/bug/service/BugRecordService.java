package cn.edu.sdu.orz.bug.service;

import cn.edu.sdu.orz.bug.dto.BugRecordDTO;
import cn.edu.sdu.orz.bug.entity.BugRecord;
import cn.edu.sdu.orz.bug.repository.BugRecordRepository;
import cn.edu.sdu.orz.bug.vo.BugRecordQueryVO;
import cn.edu.sdu.orz.bug.vo.BugRecordUpdateVO;
import cn.edu.sdu.orz.bug.vo.BugRecordVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class BugRecordService {

    @Autowired
    private BugRecordRepository bugRecordRepository;

    public String save(BugRecordVO vO) {
        BugRecord bean = new BugRecord();
        BeanUtils.copyProperties(vO, bean);
        bean = bugRecordRepository.save(bean);
        return bean.getId();
    }

    public void delete(String id) {
        bugRecordRepository.deleteById(id);
    }

    public void update(String id, BugRecordUpdateVO vO) {
        BugRecord bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        bugRecordRepository.save(bean);
    }

    public BugRecordDTO getById(String id) {
        BugRecord original = requireOne(id);
        return toDTO(original);
    }

    public Page<BugRecordDTO> query(BugRecordQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private BugRecordDTO toDTO(BugRecord original) {
        BugRecordDTO bean = new BugRecordDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private BugRecord requireOne(String id) {
        return bugRecordRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
