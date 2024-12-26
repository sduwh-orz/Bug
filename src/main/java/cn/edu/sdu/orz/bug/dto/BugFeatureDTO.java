package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.Feature;
import cn.edu.sdu.orz.bug.entity.Module;
import cn.edu.sdu.orz.bug.entity.User;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.math.BigDecimal;

public class BugFeatureDTO implements Serializable {

    private String id;

    private String name;

    private BugModuleDTO module;

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

    public BugModuleDTO getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = BugModuleDTO.toDTO(module);
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
        if (owner != null)
            this.owner = UserBriefDTO.toDTO(owner);
    }

    public static BugFeatureDTO toDTO(Feature original) {
        BugFeatureDTO bean = new BugFeatureDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }
}
