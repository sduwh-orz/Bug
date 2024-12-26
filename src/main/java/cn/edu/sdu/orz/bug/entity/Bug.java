package cn.edu.sdu.orz.bug.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * The type Bug.
 */
@Entity
@Table(name = "bug")
@SuppressWarnings("unused")
public class Bug {

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
    @JoinColumn(name = "solve_type", nullable = false)
    private BugSolveType solveType;

    @Column(name = "created", nullable = false)
    private Timestamp created;

    @Column(name = "modified")
    private Timestamp modified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feature", nullable = false)
    private Feature feature;

    @OneToMany(mappedBy = "bug", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @OrderBy("time DESC")
    private List<BugRecord> records;

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets reporter.
     *
     * @param reporter the reporter
     */
    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    /**
     * Gets reporter.
     *
     * @return the reporter
     */
    public User getReporter() {
        return reporter;
    }

    /**
     * Gets grade.
     *
     * @return the grade
     */
    public BugGrade getGrade() {
        return grade;
    }

    /**
     * Sets grade.
     *
     * @param grade the grade
     */
    public void setGrade(BugGrade grade) {
        this.grade = grade;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public BugStatus getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(BugStatus status) {
        this.status = status;
    }

    /**
     * Gets solve type.
     *
     * @return the solve type
     */
    public BugSolveType getSolveType() {
        return solveType;
    }

    /**
     * Sets solve type.
     *
     * @param solveType the solve type
     */
    public void setSolveType(BugSolveType solveType) {
        this.solveType = solveType;
    }

    /**
     * Sets created.
     *
     * @param created the created
     */
    public void setCreated(Timestamp created) {
        this.created = created;
    }

    /**
     * Gets created.
     *
     * @return the created
     */
    public Timestamp getCreated() {
        return created;
    }

    /**
     * Sets modified.
     *
     * @param modified the modified
     */
    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    /**
     * Gets modified.
     *
     * @return the modified
     */
    public Timestamp getModified() {
        return modified;
    }

    /**
     * Gets feature.
     *
     * @return the feature
     */
    public Feature getFeature() {
        return feature;
    }

    /**
     * Sets feature.
     *
     * @param feature the feature
     */
    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    /**
     * Gets records.
     *
     * @return the records
     */
    public List<BugRecord> getRecords() {
        return records;
    }

    /**
     * Sets records.
     *
     * @param records the records
     */
    public void setRecords(List<BugRecord> records) {
        this.records = records;
    }

    /**
     * Instantiates a new Bug.
     *
     * @param id          the id
     * @param name        the name
     * @param description the description
     * @param grade       the grade
     * @param reporter    the reporter
     * @param status      the status
     * @param solveType   the solve type
     * @param created     the created
     * @param modified    the modified
     * @param feature     the feature
     * @param records     the records
     */
    public Bug(String id, String name, String description, BugGrade grade, User reporter,
               BugStatus status, BugSolveType solveType, Timestamp created, Timestamp modified,
               Feature feature, List<BugRecord> records) {
        setId(id);
        setName(name);
        setGrade(grade);
        setReporter(reporter);
        setStatus(status);
        setSolveType(solveType);
        setCreated(created);
        setModified(modified);
        setFeature(feature);
        setDescription(description);
        setRecords(records);
    }

    /**
     * Instantiates a new Bug.
     */
    public Bug() {
        super();
    }

    @Override
    public String toString() {
        return "Bug{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", grade=" + getGrade().getName() +
                ", reporter=" + getReporter().getRealName() +
                ", status=" + getStatus().getName() +
                ", solveType=" + getSolveType().getName() +
                ", created=" + getCreated() +
                ", modified=" + getModified() +
                ", feature=" + getFeature().getName() +
                ", records=" + getRecords() +
                '}';
    }
}
