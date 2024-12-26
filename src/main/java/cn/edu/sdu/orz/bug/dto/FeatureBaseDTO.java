package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.User;

import java.math.BigDecimal;

/**
 * The type Feature base dto.
 */
@SuppressWarnings("unused")
public class FeatureBaseDTO {

    private String id;

    private String name;

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
}
