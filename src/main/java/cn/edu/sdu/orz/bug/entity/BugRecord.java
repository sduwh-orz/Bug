package cn.edu.sdu.orz.bug.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "bug_record")
public class BugRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "bug", nullable = false)
    private String bug;

    @Column(name = "type", nullable = false)
    private Integer type;

    @Column(name = "previous", nullable = false)
    private Integer previous;

    @Column(name = "after", nullable = false)
    private Integer after;

    @Column(name = "solve_type")
    private Integer solveType;

    @Column(name = "comment", nullable = false)
    private String comment;

    @Column(name = "user", nullable = false)
    private String user;

    @Column(name = "time", nullable = false)
    private Date time;

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

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setPrevious(Integer previous) {
        this.previous = previous;
    }

    public Integer getPrevious() {
        return previous;
    }

    public void setAfter(Integer after) {
        this.after = after;
    }

    public Integer getAfter() {
        return after;
    }

    public void setSolveType(Integer solveType) {
        this.solveType = solveType;
    }

    public Integer getSolveType() {
        return solveType;
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

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
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
