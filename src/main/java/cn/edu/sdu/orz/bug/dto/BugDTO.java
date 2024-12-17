package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.*;
import cn.edu.sdu.orz.bug.utils.Utils;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class BugDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;

    private FeatureDTO feature;

    private String name;

    private String description;

    private TypeDTO grade;

    private UserBriefDTO reporter;

    private TypeDTO status;

    private TypeDTO solveType;

    private Timestamp created;

    private Timestamp modified;

    private List<BugRecordDTO> records;

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

    public TypeDTO getGrade() {
        return grade;
    }

    public void setGrade(BugGrade original) {
        this.grade = TypeDTO.toDTO(original);
    }

    public UserBriefDTO getReporter() {
        return reporter;
    }

    public void setReporter(User original) {
        UserBriefDTO bean = new UserBriefDTO();
        BeanUtils.copyProperties(original, bean);
        this.reporter = bean;
    }

    public TypeDTO getStatus() {
        return status;
    }

    public void setStatus(BugStatus original) {
        this.status = TypeDTO.toDTO(original);
    }

    public TypeDTO getSolveType() {
        return solveType;
    }

    public void setSolveType(BugSolveType original) {
        if (original != null) {
            this.solveType = TypeDTO.toDTO(original);
        }
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

    public String getModified() {
        if (modified != null) {
            return Utils.dateFormat.format(modified);
        }
        return "";
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public List<BugRecordDTO> getRecords() {
        return records;
    }

    public void setRecords(List<BugRecord> records) {
        this.records = records.stream().map(r -> {
            BugRecordDTO bean = new BugRecordDTO();
            BeanUtils.copyProperties(r, bean);
            return bean;
        }).toList();
    }
}
