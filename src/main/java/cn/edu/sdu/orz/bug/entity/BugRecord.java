package cn.edu.sdu.orz.bug.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "bug_record")
public class BugRecord implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "bug", nullable = false)
    private Bug bug;

    @ManyToOne
    @JoinColumn(name = "type", nullable = false)
    private BugRecordType type;

    @ManyToOne
    @JoinColumn(name = "previous", nullable = false)
    private BugStatus previous;

    @ManyToOne
    @JoinColumn(name = "after", nullable = false)
    private BugStatus after;

    @ManyToOne
    @JoinColumn(name = "solve_type")
    private BugSolveType solveType;

    @Column(name = "comment", nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private User user;

    @Column(name = "time", nullable = false)
    private Timestamp time;

    public BugRecord() {
        super();
    }

    public BugRecord(String id, Bug bug, BugRecordType type, BugStatus previous, BugStatus after, BugSolveType solveType,
                     String comment, User user, Timestamp time) {
        setId(id);
        setBug(bug);
        setType(type);
        setPrevious(previous);
        setAfter(after);
        setSolveType(solveType);
        setComment(comment);
        setUser(user);
        setTime(time);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setBug(Bug bug) {
        this.bug = bug;
    }

    public Bug getBug() {
        return bug;
    }

    public BugRecordType getType() {
        return type;
    }

    public void setType(BugRecordType type) {
        this.type = type;
    }

    public BugStatus getPrevious() {
        return previous;
    }

    public void setPrevious(BugStatus previous) {
        this.previous = previous;
    }

    public BugStatus getAfter() {
        return after;
    }

    public void setAfter(BugStatus after) {
        this.after = after;
    }

    public BugSolveType getSolveType() {
        return solveType;
    }

    public void setSolveType(BugSolveType solveType) {
        this.solveType = solveType;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Timestamp getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "BugRecord{" +
                "id=" + getId() + '\'' +
                "bug=" + getBug().getId() + '\'' +
                "type=" + getType().getName() + '\'' +
                "previous=" + getPrevious().getName() + '\'' +
                "after=" + getAfter().getName() + '\'' +
                "solveType=" + getSolveType().getName() + '\'' +
                "comment=" + getComment() + '\'' +
                "user=" + getUser().getRealName() + '\'' +
                "time=" + getTime() + '\'' +
                '}';
    }
}
