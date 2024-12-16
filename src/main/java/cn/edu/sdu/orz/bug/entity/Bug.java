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

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "grade", nullable = false)
    private Integer grade;

    @Column(name = "reporter", nullable = false)
    private String reporter;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "solve_type")
    private Integer solveType;

    @Column(name = "created", nullable = false)
    private Date created;

    @Column(name = "modified")
    private Date modified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feature", nullable = false)
    private Feature feature;

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

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getReporter() {
        return reporter;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setSolveType(Integer solveType) {
        this.solveType = solveType;
    }

    public Integer getSolveType() {
        return solveType;
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

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
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
