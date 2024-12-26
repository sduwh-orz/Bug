package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.User;
import org.springframework.beans.BeanUtils;

/**
 * The type User brief dto.
 */
@SuppressWarnings("unused")
public class UserBriefDTO {
    private String id;

    private String realName;

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
     * Gets real name.
     *
     * @return the real name
     */
    public String getRealName() {
        return realName;
    }

    /**
     * Sets real name.
     *
     * @param realName the real name
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

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
