package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.*;
import cn.edu.sdu.orz.bug.utils.Utils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Bug dto.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class BugDTO extends BaseDTO {
    private BugFeatureDTO feature;

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
     * Sets feature.
     *
     * @param original the original
     */
    public void setFeature(Feature original) {
        this.feature = BugFeatureDTO.toDTO(original);
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
     * Sets status.
     *
     * @param original the original
     */
    public void setStatus(BugStatus original) {
        this.status = TypeDTO.toDTO(original);
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
