package cn.edu.sdu.orz.bug.service;

import cn.edu.sdu.orz.bug.entity.Module;
import cn.edu.sdu.orz.bug.repository.ModuleRepository;
import cn.edu.sdu.orz.bug.utils.Utils;
import cn.edu.sdu.orz.bug.vo.ModuleCreateVO;
import cn.edu.sdu.orz.bug.vo.ModuleUpdateVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    public boolean create(ModuleCreateVO moduleCreateVO, HttpSession httpSession) {
        if (userService.isNotLoggedIn(httpSession)) {
            return false;
        }
        try {
            Module bean = new Module();
            BeanUtils.copyProperties(moduleCreateVO, bean, Utils.getNullPropertyNames(moduleCreateVO));
            bean.setId(newID());
            bean.setName(moduleCreateVO.getName());
            bean.setProject(projectService.requireOne(moduleCreateVO.getProjectId()));
            moduleRepository.save(bean);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean modify(ModuleUpdateVO vO, HttpSession httpSession) {
        if (userService.isNotLoggedIn(httpSession)) {
            return false;
        }
        try {
            Module bean = requireOne(vO.getId());
            BeanUtils.copyProperties(vO, bean, Utils.getNullPropertyNames(vO));
            moduleRepository.save(bean);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean remove(String id, HttpSession httpSession) {
        if (userService.isNotLoggedIn(httpSession)) {
            return false;
        }
        try {
            Module bean = requireOne(id);
            moduleRepository.delete(bean);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

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
