package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.Feature;
import cn.edu.sdu.orz.bug.entity.Module;
import cn.edu.sdu.orz.bug.entity.Project;
import cn.edu.sdu.orz.bug.entity.User;
import cn.edu.sdu.orz.bug.utils.Utils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Project dto.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class ProjectDTO extends BaseDTO {
    private String keyword;

    private String description;

    private UserDTO owner;

    private Timestamp created;

    private List<ModuleDTO> modules;

    /**
     * Sets owner.
     *
     * @param owner the owner
     */
    public void setOwner(User owner) {
        this.owner = UserDTO.toDTO(owner);
    }

    /**
     * Gets created.
     *
     * @return the created
     */
    public String getCreated() {
        if (created != null) {
            return Utils.dateFormat.format(created);
        }
        return "";
    }

    /**
     * Sets modules.
     *
     * @param modules the modules
     */
    public void setModules(List<Module> modules) {
        this.modules = modules.stream().map(module -> {
            ModuleDTO bean = ModuleDTO.toDTO(module);
            bean.setFeatureHoursSum(module.getFeatures().stream()
                    .map(Feature::getHours).reduce(BigDecimal.ZERO, BigDecimal::add)
            );
            return bean;
        }).collect(Collectors.toList());
    }

    /**
     * To dto project dto.
     *
     * @param original the original
     * @return the project dto
     */
    public static ProjectDTO toDTO(Project original) {
        ProjectDTO bean = new ProjectDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }
}
