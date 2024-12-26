package cn.edu.sdu.orz.bug.dto;


import cn.edu.sdu.orz.bug.entity.Module;
import cn.edu.sdu.orz.bug.entity.Project;
import org.springframework.beans.BeanUtils;

/**
 * The type Bug module dto.
 */
@SuppressWarnings("unused")
public class BugModuleDTO {
    private String id;

    private String name;

    private ProjectDTO project;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets project.
     *
     * @return the project
     */
    public ProjectDTO getProject() {
        return project;
    }

    /**
     * Sets project.
     *
     * @param project the project
     */
    public void setProject(Project project) {
        this.project = ProjectDTO.toDTO(project);
    }

    /**
     * To dto bug module dto.
     *
     * @param original the original
     * @return the bug module dto
     */
    public static BugModuleDTO toDTO(Module original) {
        BugModuleDTO bean = new BugModuleDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }
}
