package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.*;
import cn.edu.sdu.orz.bug.utils.Utils;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;

/**
 * The type Bug record dto.
 */
@SuppressWarnings("unused")
public class BugRecordDTO {
    private String id;

    private BugRecordTypeDTO type;

    private TypeDTO previous;

    private TypeDTO after;

    private TypeDTO solveType;

    private String comment;

    private UserBriefDTO user;

    private Timestamp time;

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
     * Gets type.
     *
     * @return the type
     */
    public BugRecordTypeDTO getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(BugRecordType type) {
        this.type = BugRecordTypeDTO.toDTO(type);
    }

    /**
     * Gets previous.
     *
     * @return the previous
     */
    public TypeDTO getPrevious() {
        return previous;
    }

    /**
     * Sets previous.
     *
     * @param previous the previous
     */
    public void setPrevious(BugStatus previous) {
        this.previous = TypeDTO.toDTO(previous);
    }

    /**
     * Gets after.
     *
     * @return the after
     */
    public TypeDTO getAfter() {
        return after;
    }

    /**
     * Sets after.
     *
     * @param after the after
     */
    public void setAfter(BugStatus after) {
        this.after = TypeDTO.toDTO(after);
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
     * @param solveType the solve type
     */
    public void setSolveType(BugSolveType solveType) {
        if (solveType != null) {
            this.solveType = TypeDTO.toDTO(solveType);
        }
    }

    /**
     * Gets comment.
     *
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets comment.
     *
     * @param comment the comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public UserBriefDTO getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        UserBriefDTO bean = new UserBriefDTO();
        BeanUtils.copyProperties(user, bean);
        this.user = bean;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public String getTime() {
        if (time != null) {
            return Utils.dateFormat.format(time);
        }
        return "";
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(Timestamp time) {
        this.time = time;
    }

    /**
     * To dto bug record dto.
     *
     * @param original the original
     * @return the bug record dto
     */
    public static BugRecordDTO toDTO(BugRecord original) {
        BugRecordDTO bean = new BugRecordDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }
}
