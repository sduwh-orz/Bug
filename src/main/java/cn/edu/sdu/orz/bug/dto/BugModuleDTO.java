package cn.edu.sdu.orz.bug.dto;


import cn.edu.sdu.orz.bug.entity.Module;
import cn.edu.sdu.orz.bug.entity.Project;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

public class BugModuleDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;

    private String name;

    private ProjectDTO project;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = ProjectDTO.toDTO(project);
    }

    public static BugModuleDTO toDTO(Module original) {
        BugModuleDTO bean = new BugModuleDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }
}
