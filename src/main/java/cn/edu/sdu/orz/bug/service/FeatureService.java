package cn.edu.sdu.orz.bug.service;

import cn.edu.sdu.orz.bug.dto.FeatureDTO;
import cn.edu.sdu.orz.bug.entity.Feature;
import cn.edu.sdu.orz.bug.repository.FeatureRepository;
import cn.edu.sdu.orz.bug.vo.FeatureQueryVO;
import cn.edu.sdu.orz.bug.vo.FeatureUpdateVO;
import cn.edu.sdu.orz.bug.vo.FeatureVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class FeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    public String save(FeatureVO vO) {
        Feature bean = new Feature();
        BeanUtils.copyProperties(vO, bean);
        bean = featureRepository.save(bean);
        return bean.getId();
    }

    public void delete(String id) {
        featureRepository.deleteById(id);
    }

    public void update(String id, FeatureUpdateVO vO) {
        Feature bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        featureRepository.save(bean);
    }

    public FeatureDTO getById(String id) {
        Feature original = requireOne(id);
        return toDTO(original);
    }

    public Page<FeatureDTO> query(FeatureQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private FeatureDTO toDTO(Feature original) {
        FeatureDTO bean = new FeatureDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Feature requireOne(String id) {
        return featureRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
