package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.*;
import cn.edu.sdu.orz.bug.utils.Utils;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Bug dto.
 */
@SuppressWarnings("unused")
public class BugDTO {
    private String id;

    private BugFeatureDTO feature;

    private String name;

    private String description;

    private TypeDTO grade;

    private UserBriefDTO developer;

    private UserBriefDTO reporter;

    private TypeDTO status;

    private TypeDTO solveType;

    private Timestamp created;

    private Timestamp modified;

    private List<BugRecordDTO> records;

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
     * Gets feature.
     *
     * @return the feature
     */
    public BugFeatureDTO getFeature() {
        return feature;
    }

    /**
     * Sets feature.
     *
     * @param original the original
     */
    public void setFeature(Feature original) {
        this.feature = BugFeatureDTO.toDTO(original);
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
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets grade.
     *
     * @return the grade
     */
    public TypeDTO getGrade() {
        return grade;
    }

    /**
     * Sets grade.
     *
     * @param original the original
     */
    public void setGrade(BugGrade original) {
        this.grade = TypeDTO.toDTO(original);
    }

    /**
     * Gets developer.
     *
     * @return the developer
     */
    public UserBriefDTO getDeveloper() {
        return developer;
    }

    /**
     * Sets developer.
     *
     * @param developer the developer
     */
    public void setDeveloper(UserBriefDTO developer) {
        this.developer = developer;
    }

    /**
     * Gets reporter.
     *
     * @return the reporter
     */
    public UserBriefDTO getReporter() {
        return reporter;
    }

    /**
     * Sets reporter.
     *
     * @param original the original
     */
    public void setReporter(User original) {
        UserBriefDTO bean = new UserBriefDTO();
        BeanUtils.copyProperties(original, bean);
        this.reporter = bean;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public TypeDTO getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param original the original
     */
    public void setStatus(BugStatus original) {
        this.status = TypeDTO.toDTO(original);
    }

    /**
     * Gets solve type.
     *
     * @return the solve type
     */
    public TypeDTO getSolveType() {
        return solveType;
    }

    /**
     * Sets solve type.
     *
     * @param original the original
     */
    public void setSolveType(BugSolveType original) {
        if (original != null) {
            this.solveType = TypeDTO.toDTO(original);
        }
    }

    /**
     * Gets created.
     *
     * @return the created
     */
    public String getCreated() {
        if (created != null) {
            return Utils.dateFormat.format(created);
        }
        return "";
    }

    /**
     * Sets created.
     *
     * @param created the created
     */
    public void setCreated(Timestamp created) {
        this.created = created;
    }

    /**
     * Gets modified.
     *
     * @return the modified
     */
    public String getModified() {
        if (modified != null) {
            return Utils.dateFormat.format(modified);
        }
        return "";
    }

    /**
     * Sets modified.
     *
     * @param modified the modified
     */
    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    /**
     * Gets records.
     *
     * @return the records
     */
    public List<BugRecordDTO> getRecords() {
        return records;
    }

    /**
     * Sets records.
     *
     * @param records the records
     */
    public void setRecords(List<BugRecord> records) {
        this.records = records.stream().map(BugRecordDTO::toDTO).collect(Collectors.toList());
    }

    /**
     * To dto bug dto.
     *
     * @param original the original
     * @return the bug dto
     */
    public static BugDTO toDTO(Bug original) {
        if (original == null)
            return null;
        BugDTO bean = new BugDTO();
        BeanUtils.copyProperties(original, bean);
        User developer = original.getFeature().getOwner();
        if (developer != null) {
            bean.setDeveloper(UserBriefDTO.toDTO(developer));
        }
        return bean;
    }
}
