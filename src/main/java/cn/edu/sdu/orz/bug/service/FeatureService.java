package cn.edu.sdu.orz.bug.service;

import cn.edu.sdu.orz.bug.dto.FeatureDTO;
import cn.edu.sdu.orz.bug.entity.Feature;
import cn.edu.sdu.orz.bug.repository.FeatureRepository;
import cn.edu.sdu.orz.bug.utils.Utils;
import cn.edu.sdu.orz.bug.vo.FeatureUpdateVO;
import cn.edu.sdu.orz.bug.vo.FeatureVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class FeatureService {

    @Autowired
    private UserService userService;

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private FeatureRepository featureRepository;

    public boolean create(FeatureVO vO, HttpSession session) {
        if (userService.isNotLoggedIn(session))
            return false;
        try {
            Feature bean = new Feature();
            BeanUtils.copyProperties(vO, bean, Utils.getNullPropertyNames(vO));
            bean.setId(newID());
            bean.setModule(moduleService.requireOne(vO.getModule()));
            featureRepository.save(bean);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean modify(FeatureUpdateVO vO, HttpSession session) {
        if (userService.isNotLoggedIn(session))
            return false;
        try {
            Feature bean = requireOne(vO.getId());
            BeanUtils.copyProperties(vO, bean, Utils.getNullPropertyNames(vO));
            if (vO.getOwner() != null)
                bean.setOwner(userService.requireOne(vO.getOwner()));
            featureRepository.save(bean);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean remove(String id, HttpSession session) {
        if (userService.isNotLoggedIn(session))
            return false;
        try {
            featureRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private FeatureDTO toDTO(Feature original) {
        FeatureDTO bean = new FeatureDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    public Feature requireOne(String id) {
        return featureRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    private String newID() {
        while (true) {
            String id = Utils.newRandomID();
            if (!featureRepository.existsById(id)) {
                return id;
            }
        }
    }
}
