package cn.edu.sdu.orz.bug.service;

import cn.edu.sdu.orz.bug.dto.ModuleDTO;
import cn.edu.sdu.orz.bug.entity.Module;
import cn.edu.sdu.orz.bug.entity.Project;
import cn.edu.sdu.orz.bug.repository.ModuleRepository;
import cn.edu.sdu.orz.bug.repository.ProjectRepository;
import cn.edu.sdu.orz.bug.utils.Utils;
import cn.edu.sdu.orz.bug.vo.ModuleCreateVO;
import cn.edu.sdu.orz.bug.vo.ModuleQueryVO;
import cn.edu.sdu.orz.bug.vo.ModuleUpdateVO;
import cn.edu.sdu.orz.bug.vo.ModuleVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.function.Function;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectService projectService;

    public String save(ModuleVO vO) {
        Module bean = new Module();
        BeanUtils.copyProperties(vO, bean);
        bean = moduleRepository.save(bean);
        return bean.getId();
    }

    public void delete(String id) {
        moduleRepository.deleteById(id);
    }

    public void update(String id, ModuleUpdateVO vO) {
        Module bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        moduleRepository.save(bean);
    }

    public ModuleDTO getById(String id) {
        Module original = requireOne(id);
        return toDTO(original);
    }

    public boolean create(ModuleCreateVO moduleCreateVO, HttpSession httpSession) {
//        User user = userService.getLoggedInUser(httpSession);
//        if (user == null) {
//            return false;
//        }
//        if (userService.isLoggedInUserNotAdmin(httpSession)) {
//            Project project = requireOne(id);
//            if (!project.getOwner().equals(user.getId())) {
//                return false;
//            }
//        }
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

    public boolean modify(String id, ModuleUpdateVO moduleUpdateVO, HttpSession httpSession) {
//        User user = userService.getLoggedInUser(httpSession);
//        if (user == null) {
//            return false;
//        }
//        if (userService.isLoggedInUserNotAdmin(httpSession)) {
//            Project project = requireOne(id);
//            if (!project.getOwner().equals(user.getId())) {
//                return false;
//            }
//        }
        try {
            Module bean = requireOne(id);
            BeanUtils.copyProperties(moduleUpdateVO, bean, Utils.getNullPropertyNames(moduleUpdateVO));
            moduleRepository.save(bean);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean remove(String id, HttpSession httpSession) {
//        User user = userService.getLoggedInUser(httpSession);
//        if (user == null) {
//            return false;
//        }
//        if (userService.isLoggedInUserNotAdmin(httpSession)) {
//            Project project = requireOne(id);
//            if (!project.getOwner().equals(user.getId())) {
//                return false;
//            }
//        }
        try {
            Module bean = requireOne(id);
            moduleRepository.delete(bean);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Page<ModuleDTO> query(ModuleQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ModuleDTO toDTO(Module original) {
        ModuleDTO bean = new ModuleDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Module requireOne(String id) {
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
