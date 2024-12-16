package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.BugRecordType;
import cn.edu.sdu.orz.bug.entity.BugSolveType;
import cn.edu.sdu.orz.bug.entity.BugStatus;
import cn.edu.sdu.orz.bug.entity.User;
import cn.edu.sdu.orz.bug.utils.Utils;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.sql.Timestamp;

public class BugRecordDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;

    private BugRecordType type;

    private BugStatusDTO previous;

    private BugStatusDTO after;

    private BugSolveTypeDTO solveType;

    private String comment;

    private UserBriefDTO user;

    private Timestamp time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BugRecordType getType() {
        return type;
    }

    public void setType(BugRecordType type) {
        BugRecordType bean = new BugRecordType();
        BeanUtils.copyProperties(type, bean);
        this.type = bean;
    }

    public BugStatusDTO getPrevious() {
        return previous;
    }

    public void setPrevious(BugStatus previous) {
        BugStatusDTO bean = new BugStatusDTO();
        BeanUtils.copyProperties(previous, bean);
        this.previous = bean;
    }

    public BugStatusDTO getAfter() {
        return after;
    }

    public void setAfter(BugStatus after) {
        BugStatusDTO bean = new BugStatusDTO();
        BeanUtils.copyProperties(after, bean);
        this.after = bean;
    }

    public BugSolveTypeDTO getSolveType() {
        return solveType;
    }

    public void setSolveType(BugSolveType solveType) {
        if (solveType != null) {
            BugSolveTypeDTO bean = new BugSolveTypeDTO();
            BeanUtils.copyProperties(solveType, bean);
            this.solveType = bean;
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
}
