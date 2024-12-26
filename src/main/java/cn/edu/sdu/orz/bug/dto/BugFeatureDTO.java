package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.Feature;
import cn.edu.sdu.orz.bug.entity.Module;
import cn.edu.sdu.orz.bug.entity.User;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

/**
 * The type Bug feature dto.
 */
@SuppressWarnings("unused")
public class BugFeatureDTO {

    private String id;

    private String name;

    private BugModuleDTO module;

    private BigDecimal hours;

    private UserBriefDTO owner;

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
     * Gets module.
     *
     * @return the module
     */
    public BugModuleDTO getModule() {
        return module;
    }

    /**
     * Sets module.
     *
     * @param module the module
     */
    public void setModule(Module module) {
        this.module = BugModuleDTO.toDTO(module);
    }

    /**
     * Gets hours.
     *
     * @return the hours
     */
    public BigDecimal getHours() {
        return hours;
    }

    /**
     * Sets hours.
     *
     * @param hours the hours
     */
    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }

    /**
     * Gets owner.
     *
     * @return the owner
     */
    public UserBriefDTO getOwner() {
        return owner;
    }

    /**
     * Sets owner.
     *
     * @param owner the owner
     */
    public void setOwner(User owner) {
        if (owner != null)
            this.owner = UserBriefDTO.toDTO(owner);
    }

    /**
     * To dto bug feature dto.
     *
     * @param original the original
     * @return the bug feature dto
     */
    public static BugFeatureDTO toDTO(Feature original) {
        BugFeatureDTO bean = new BugFeatureDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }
}
