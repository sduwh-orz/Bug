package cn.edu.sdu.orz.bug.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "bug_record")
public class BugRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "bug", nullable = false)
    private String bug;

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

    @Column(name = "user", nullable = false)
    private String user;

    @Column(name = "time", nullable = false)
    private Timestamp time;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setBug(String bug) {
        this.bug = bug;
    }

    public String getBug() {
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

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
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
                "id=" + id + '\'' +
                "bug=" + bug + '\'' +
                "type=" + type + '\'' +
                "previous=" + previous + '\'' +
                "after=" + after + '\'' +
                "solveType=" + solveType + '\'' +
                "comment=" + comment + '\'' +
                "user=" + user + '\'' +
                "time=" + time + '\'' +
                '}';
    }
}
