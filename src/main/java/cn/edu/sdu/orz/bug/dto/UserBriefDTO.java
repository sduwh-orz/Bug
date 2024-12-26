package cn.edu.sdu.orz.bug.dto;


import cn.edu.sdu.orz.bug.entity.User;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

public class UserBriefDTO implements Serializable {
    private String id;

    private String realName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public static UserBriefDTO toDTO(User original) {
        UserBriefDTO bean = new UserBriefDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }
}
