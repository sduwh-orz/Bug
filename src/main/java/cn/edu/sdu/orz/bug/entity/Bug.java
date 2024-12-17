package cn.edu.sdu.orz.bug.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "bug")
public class Bug implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
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
    private Timestamp created;

    @Column(name = "modified")
    private Timestamp modified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feature", nullable = false)
    private Feature feature;

    @OneToMany(mappedBy = "bug", fetch = FetchType.EAGER)
    private List<BugRecord> records;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public Timestamp getModified() {
        return modified;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public List<BugRecord> getRecords() {
        return records;
    }

    public void setRecords(List<BugRecord> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "Bug{" +
                "id=" + id + '\'' +
                "feature=" + (feature != null ? feature.getId() : null) + '\'' +
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
