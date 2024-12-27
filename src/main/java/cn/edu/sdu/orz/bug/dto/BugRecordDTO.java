package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.*;
import cn.edu.sdu.orz.bug.utils.Utils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;

/**
 * The type Bug record dto.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class BugRecordDTO {
    private String id;

    private BaseDTO type;

    private TypeDTO previous;

    private TypeDTO after;

    private TypeDTO solveType;

    private String comment;

    private UserBriefDTO user;

    private Timestamp time;

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(BugRecordType type) {
        this.type = BaseDTO.toDTO(type);
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
     * Sets after.
     *
     * @param after the after
     */
    public void setAfter(BugStatus after) {
        this.after = TypeDTO.toDTO(after);
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
