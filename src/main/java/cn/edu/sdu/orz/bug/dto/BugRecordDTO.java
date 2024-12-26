package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.*;
import cn.edu.sdu.orz.bug.utils.Utils;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.sql.Timestamp;

public class BugRecordDTO implements Serializable {
    private String id;

    private BugRecordTypeDTO type;

    private TypeDTO previous;

    private TypeDTO after;

    private TypeDTO solveType;

    private String comment;

    private UserBriefDTO user;

    private Timestamp time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BugRecordTypeDTO getType() {
        return type;
    }

    public void setType(BugRecordType type) {
        this.type = BugRecordTypeDTO.toDTO(type);
    }

    public TypeDTO getPrevious() {
        return previous;
    }

    public void setPrevious(BugStatus previous) {
        this.previous = TypeDTO.toDTO(previous);
    }

    public TypeDTO getAfter() {
        return after;
    }

    public void setAfter(BugStatus after) {
        this.after = TypeDTO.toDTO(after);
    }

    public TypeDTO getSolveType() {
        return solveType;
    }

    public void setSolveType(BugSolveType solveType) {
        if (solveType != null) {
            this.solveType = TypeDTO.toDTO(solveType);
        }
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public UserBriefDTO getUser() {
        return user;
    }

    public void setUser(User user) {
        UserBriefDTO bean = new UserBriefDTO();
        BeanUtils.copyProperties(user, bean);
        this.user = bean;
    }

    public String getTime() {
        if (time != null) {
            return Utils.dateFormat.format(time);
        }
        return "";
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public static BugRecordDTO toDTO(BugRecord original) {
        BugRecordDTO bean = new BugRecordDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }
}
