package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.*;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.sql.Date;

public class BugDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;

    private FeatureDTO feature;

    private String name;

    private String description;

    private BugGradeDTO grade;

    private UserDTO reporter;

    private BugStatusDTO status;

    private BugSolveTypeDTO solveType;

    private Date created;

    private Date modified;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FeatureDTO getFeature() {
        return feature;
    }

    public void setFeature(Feature original) {
        FeatureDTO bean = new FeatureDTO();
        BeanUtils.copyProperties(original, bean);
        this.feature = bean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGrade() {
        return grade.getName();
    }

    public void setGrade(BugGrade original) {
        BugGradeDTO bean = new BugGradeDTO();
        BeanUtils.copyProperties(original, bean);
        this.grade = bean;
    }

    public UserDTO getReporter() {
        return reporter;
    }

    public void setReporter(User original) {
        UserDTO bean = new UserDTO();
        BeanUtils.copyProperties(original, bean);
        this.reporter = bean;
    }

    public String getStatus() {
        return status.getName();
    }

    public void setStatus(BugStatus original) {
        BugStatusDTO bean = new BugStatusDTO();
        BeanUtils.copyProperties(original, bean);
        this.status = bean;
    }

    public String getSolveType() {
        return solveType.getName();
    }

    public void setSolveType(BugSolveType original) {
        BugSolveTypeDTO bean = new BugSolveTypeDTO();
        BeanUtils.copyProperties(original, bean);
        this.solveType = bean;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
