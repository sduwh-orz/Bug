package cn.edu.sdu.orz.bug.service;

import cn.edu.sdu.orz.bug.dto.ProjectDTO;
import cn.edu.sdu.orz.bug.dto.ProjectInBugListDTO;
import cn.edu.sdu.orz.bug.dto.ProjectInTaskListDTO;
import cn.edu.sdu.orz.bug.entity.Project;
import cn.edu.sdu.orz.bug.repository.ProjectRepository;
import cn.edu.sdu.orz.bug.utils.Utils;
import cn.edu.sdu.orz.bug.vo.ProjectCreateVO;
import cn.edu.sdu.orz.bug.vo.ProjectQueryVO;
import cn.edu.sdu.orz.bug.vo.ProjectUpdateVO;
import cn.edu.sdu.orz.bug.vo.ProjectVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserService userService;

    public String save(ProjectVO vO) {
        Project bean = new Project();
        BeanUtils.copyProperties(vO, bean);
        bean = projectRepository.save(bean);
        return bean.getId();
    }

    public void delete(String id) {
        projectRepository.deleteById(id);
    }

    public void update(String id, ProjectUpdateVO vO) {
        Project bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        projectRepository.save(bean);
    }

    public ProjectDTO getById(String id) {
        Project original = requireOne(id);
        return toDTO(original);
    }

    public Page<ProjectDTO> query(ProjectQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    public List<ProjectDTO> findByName(String projectName) {
        List<Project> projectList = projectRepository.findByName(projectName);
        List<ProjectDTO> projectDTOList = new ArrayList<>();
        projectList.forEach(project -> {
            projectDTOList.add(toDTO(project));
        });
        return projectDTOList;
    }

    public List<ProjectInTaskListDTO> findProjectsWithModuleAndOwnerCount(String projectName) {
        return projectRepository.findProjectsWithModuleAndOwnerCount(projectName);
    }

    public List<ProjectInBugListDTO> findProjectsWithBugCount(String projectName) {
        return projectRepository.findProjectsWithBugCount(projectName);
    }

    public boolean create(ProjectCreateVO projectCreateVO, HttpSession httpSession) {
//        User user = userService.getLoggedInUser(httpSession);
//        if (user == null) {
//            return false;
//        }
        try {
            Project bean = new Project();
            BeanUtils.copyProperties(projectCreateVO, bean);
            bean.setId(newID());
            bean.setName(projectCreateVO.getName());
            bean.setKeyword(projectCreateVO.getKeyword());
            bean.setDescription(projectCreateVO.getDescription());
            bean.setOwner(projectCreateVO.getOwner());
            bean.setCreated(new Timestamp(new java.util.Date(System.currentTimeMillis()).getTime()));
            projectRepository.save(bean);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean modify(String id, ProjectUpdateVO projectUpdateVO, HttpSession httpSession) {
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
            Project bean = requireOne(id);
            BeanUtils.copyProperties(projectUpdateVO, bean, Utils.getNullPropertyNames(projectUpdateVO));
            projectRepository.save(bean);
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
            Project bean = requireOne(id);
            projectRepository.delete(bean);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private ProjectDTO toDTO(Project original) {
        ProjectDTO bean = new ProjectDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    public Project requireOne(String id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    private String newID() {
        while (true) {
            String id = Utils.newRandomID();
            if (!projectRepository.existsById(id)) {
                return id;
            }
        }
    }
}
