package cn.edu.sdu.orz.bug.vo;


import java.io.Serializable;


public class BugVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String feature;

    private String name;

    private String description;

    private Integer grade;

    private Integer status;

    private Integer solveType;

    private String comment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSolveType() {
        return solveType;
    }

    public void setSolveType(Integer solveType) {
        this.solveType = solveType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
