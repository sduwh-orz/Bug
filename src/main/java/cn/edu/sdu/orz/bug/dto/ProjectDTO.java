package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.Feature;
import cn.edu.sdu.orz.bug.entity.Module;
import cn.edu.sdu.orz.bug.entity.Project;
import cn.edu.sdu.orz.bug.entity.User;
import cn.edu.sdu.orz.bug.utils.Utils;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Project dto.
 */
@SuppressWarnings("unused")
public class ProjectDTO extends ProjectBaseDTO {
    private String keyword;

    private String description;

    private UserDTO owner;

    private Timestamp created;

    private List<ModuleDTO> modules;

    /**
     * Gets keyword.
     *
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * Sets keyword.
     *
     * @param keyword the keyword
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets owner.
     *
     * @return the owner
     */
    public UserDTO getOwner() {
        return owner;
    }

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
     * Sets created.
     *
     * @param created the created
     */
    public void setCreated(Timestamp created) {
        this.created = created;
    }

    /**
     * Gets modules.
     *
     * @return the modules
     */
    public List<ModuleDTO> getModules() {
        return modules;
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
