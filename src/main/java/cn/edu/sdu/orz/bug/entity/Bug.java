package cn.edu.sdu.orz.bug.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "bug")
public class Bug implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @OneToOne
    @JoinColumn(name = "feature", nullable = false)
    private Feature feature;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "grade", nullable = false)
    private BugGrade grade;

    @ManyToOne
    @JoinColumn(name = "reporter", nullable = false)
    private User reporter;

    @ManyToOne
    @JoinColumn(name = "status", nullable = false)
    private BugStatus status;

    @ManyToOne
    @JoinColumn(name = "solve_type")
    private BugSolveType solveType;

    @Column(name = "created", nullable = false)
    private Date created;

    @Column(name = "modified")
    private Date modified;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public User getReporter() {
        return reporter;
    }

    public BugGrade getGrade() {
        return grade;
    }

    public void setGrade(BugGrade grade) {
        this.grade = grade;
    }

    public BugStatus getStatus() {
        return status;
    }

    public void setStatus(BugStatus status) {
        this.status = status;
    }

    public BugSolveType getSolveType() {
        return solveType;
    }

    public void setSolveType(BugSolveType solveType) {
        this.solveType = solveType;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getCreated() {
        return created;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getModified() {
        return modified;
    }

    @Override
    public String toString() {
        return "Bug{" +
                "id=" + id + '\'' +
                "feature=" + feature + '\'' +
                "name=" + name + '\'' +
                "description=" + description + '\'' +
                "grade=" + grade + '\'' +
                "reporter=" + reporter + '\'' +
                "status=" + status + '\'' +
                "solveType=" + solveType + '\'' +
                "created=" + created + '\'' +
                "modified=" + modified + '\'' +
                '}';
    }
}
