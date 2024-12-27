package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * The type Feature base dto.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class FeatureBaseDTO extends BaseDTO {
    /**
     * The Hours.
     */
    protected BigDecimal hours;

    /**
     * The Owner.
     */
    protected UserBriefDTO owner;

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
