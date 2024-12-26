package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.Feature;
import cn.edu.sdu.orz.bug.entity.Module;
import cn.edu.sdu.orz.bug.entity.Project;
import cn.edu.sdu.orz.bug.entity.User;
import cn.edu.sdu.orz.bug.utils.Utils;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectDTO implements Serializable {
    private String id;

    private String name;

    private String keyword;

    private String description;

    private UserDTO owner;

    private Timestamp created;

    private List<ModuleDTO> modules;

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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserDTO getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = UserDTO.toDTO(owner);
    }

    public String getCreated() {
        if (created != null) {
            return Utils.dateFormat.format(created);
        }
        return "";
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public List<ModuleDTO> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules.stream().map(module -> {
            ModuleDTO bean = ModuleDTO.toDTO(module);
            bean.setFeatureHoursSum(module.getFeatures().stream()
                    .map(Feature::getHours).reduce(BigDecimal.ZERO, BigDecimal::add)
            );
            return bean;
        }).collect(Collectors.toList());
    }

    public static ProjectDTO toDTO(Project original) {
        ProjectDTO bean = new ProjectDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }
}
