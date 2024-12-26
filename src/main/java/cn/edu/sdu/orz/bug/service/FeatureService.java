package cn.edu.sdu.orz.bug.service;

import cn.edu.sdu.orz.bug.entity.Feature;
import cn.edu.sdu.orz.bug.entity.User;
import cn.edu.sdu.orz.bug.repository.FeatureRepository;
import cn.edu.sdu.orz.bug.utils.Utils;
import cn.edu.sdu.orz.bug.vo.FeatureUpdateVO;
import cn.edu.sdu.orz.bug.vo.FeatureVO;
import cn.edu.sdu.orz.bug.vo.TaskAssignVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * Feature Service
 */
@Service
public class FeatureService {

    @Autowired
    private UserService userService;

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private FeatureRepository featureRepository;

    /**
     * Create Feature.
     *
     * @param vO      the vO
     * @param session the session
     * @return the boolean
     */
    public boolean create(FeatureVO vO, HttpSession session) {
        User user = userService.getLoggedInUser(session);
        if (user == null) {
            return false;
        }
        try {
            Feature bean = new Feature();
            BeanUtils.copyProperties(vO, bean, Utils.getNullPropertyNames(vO));
            bean.setId(newID());
            bean.setModule(moduleService.requireOne(vO.getModule()));
            if (bean.hasNoPerm(user))
                return false;
            featureRepository.save(bean);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Modify Feature.
     *
     * @param vO      the vO
     * @param session the session
     * @return the boolean
     */
    public boolean modify(FeatureUpdateVO vO, HttpSession session) {
        User user = userService.getLoggedInUser(session);
        if (user == null) {
            return false;
        }
        try {
            Feature bean = requireOne(vO.getId());
            if (bean.hasNoPerm(user))
                return false;
            BeanUtils.copyProperties(vO, bean, Utils.getNullPropertyNames(vO));
            if (vO.getOwner() != null)
                bean.setOwner(userService.requireOne(vO.getOwner()));
            featureRepository.save(bean);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Assign Feature.
     *
     * @param vO      the vO
     * @param session the session
     * @return the boolean
     */
    public boolean assign(TaskAssignVO vO, HttpSession session) {
        User user = userService.getLoggedInUser(session);
        if (user == null) {
            return false;
        }
        try {
            vO.getModules().forEach((module, features) ->
                    features.forEach((id, feature) -> {
                        Feature now = requireOne(id);
                        if (!now.hasNoPerm(user)) {
                            if (feature.getOwner() != null) {
                                now.setOwner(userService.requireOne(feature.getOwner()));
                            } else {
                                now.setOwner(null);
                            }
                            featureRepository.save(now);
                        }
                    })
            );
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Remove Feature.
     *
     * @param id      the id
     * @param session the session
     * @return the boolean
     */
    public boolean remove(String id, HttpSession session) {
        User user = userService.getLoggedInUser(session);
        if (user == null) {
            return false;
        }
        try {
            Feature bean = requireOne(id);
            if (bean.hasNoPerm(user))
                return false;
            featureRepository.delete(bean);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Require one Feature.
     *
     * @param id the id
     * @return the feature
     */
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
