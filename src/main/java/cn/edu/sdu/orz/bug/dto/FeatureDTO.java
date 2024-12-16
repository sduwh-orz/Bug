package cn.edu.sdu.orz.bug.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import cn.edu.sdu.orz.bug.entity.Module;
import cn.edu.sdu.orz.bug.entity.User;
import org.springframework.beans.BeanUtils;

public class FeatureDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;

    private String name;

    private String module;

    private BigDecimal hours;

    private UserBriefDTO owner;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module.getId();
    }

    public BigDecimal getHours() {
        return hours;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }

    public UserBriefDTO getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        UserBriefDTO bean = new UserBriefDTO();
        BeanUtils.copyProperties(owner, bean);
        this.owner = bean;
    }
}
