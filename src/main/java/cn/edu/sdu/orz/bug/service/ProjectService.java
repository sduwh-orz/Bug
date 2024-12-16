package cn.edu.sdu.orz.bug.service;

import cn.edu.sdu.orz.bug.dto.ProjectDTO;
import cn.edu.sdu.orz.bug.dto.ProjectInTaskListDTO;
import cn.edu.sdu.orz.bug.entity.Project;
import cn.edu.sdu.orz.bug.repository.ProjectRepository;
import cn.edu.sdu.orz.bug.vo.ProjectQueryVO;
import cn.edu.sdu.orz.bug.vo.ProjectUpdateVO;
import cn.edu.sdu.orz.bug.vo.ProjectVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

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

    public List<Project> findByName(String projectName) {
        return projectRepository.findByName(projectName);
    }

    public List<ProjectInTaskListDTO> findProjectsWithModuleAndOwnerCount(String projectName) {
        return projectRepository.findProjectsWithModuleAndOwnerCount(projectName);
    }

    private ProjectDTO toDTO(Project original) {
        ProjectDTO bean = new ProjectDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Project requireOne(String id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
