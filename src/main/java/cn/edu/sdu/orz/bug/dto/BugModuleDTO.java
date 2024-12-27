package cn.edu.sdu.orz.bug.dto;


import cn.edu.sdu.orz.bug.entity.Module;
import cn.edu.sdu.orz.bug.entity.Project;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

/**
 * The type Bug module dto.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class BugModuleDTO extends BaseDTO {
    private ProjectDTO project;

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
