package cn.edu.sdu.orz.bug.service;

import cn.edu.sdu.orz.bug.entity.Module;
import cn.edu.sdu.orz.bug.entity.User;
import cn.edu.sdu.orz.bug.repository.ModuleRepository;
import cn.edu.sdu.orz.bug.utils.Utils;
import cn.edu.sdu.orz.bug.vo.ModuleCreateVO;
import cn.edu.sdu.orz.bug.vo.ModuleUpdateVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * Module Service
 */
@Service
@SuppressWarnings("unused")
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    /**
     * Create Module.
     *
     * @param moduleCreateVO the module create vo
     * @param session        the session
     * @return the boolean
     */
    public boolean create(ModuleCreateVO moduleCreateVO, HttpSession session) {
        User user = userService.getLoggedInUser(session);
        if (user == null) {
            return false;
        }
        try {
            Module bean = new Module();
            BeanUtils.copyProperties(moduleCreateVO, bean, Utils.getNullPropertyNames(moduleCreateVO));
            bean.setId(newID());
            bean.setName(moduleCreateVO.getName());
            bean.setProject(projectService.requireOne(moduleCreateVO.getProjectId()));
            if (bean.hasNoPerm(user))
                return false;
            moduleRepository.save(bean);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Modify Module.
     *
     * @param vO      the vO
     * @param session the session
     * @return the boolean
     */
    public boolean modify(ModuleUpdateVO vO, HttpSession session) {
        User user = userService.getLoggedInUser(session);
        if (user == null) {
            return false;
        }
        try {
            Module bean = requireOne(vO.getId());
            if (bean.hasNoPerm(user))
                return false;
            BeanUtils.copyProperties(vO, bean, Utils.getNullPropertyNames(vO));
            moduleRepository.save(bean);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Remove Module.
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
            Module bean = requireOne(id);
            if (bean.hasNoPerm(user))
                return false;
            moduleRepository.delete(bean);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Require one Module.
     *
     * @param id the id
     * @return the module
     */
    public Module requireOne(String id) {
        return moduleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    private String newID() {
        while (true) {
            String id = Utils.newRandomID();
            if (!moduleRepository.existsById(id)) {
                return id;
            }
        }
    }
}
