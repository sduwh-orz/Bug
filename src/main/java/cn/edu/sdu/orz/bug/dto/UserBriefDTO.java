package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

/**
 * The type User brief dto.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class UserBriefDTO {
    /**
     * The ID.
     */
    protected String id;

    /**
     * The Real name.
     */
    protected String realName;

    /**
     * To dto user brief dto.
     *
     * @param original the original
     * @return the user brief dto
     */
    public static UserBriefDTO toDTO(User original) {
        UserBriefDTO bean = new UserBriefDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }
}
