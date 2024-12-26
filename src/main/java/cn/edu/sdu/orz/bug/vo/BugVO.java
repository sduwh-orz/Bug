package cn.edu.sdu.orz.bug.vo;


import java.io.Serializable;


/**
 * The type Bug vo.
 */
public class BugVO implements Serializable {

    private String id;

    private String feature;

    private String name;

    private String description;

    private Integer grade;

    private Integer status;

    private Integer solveType;

    private String comment;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets feature.
     *
     * @return the feature
     */
    public String getFeature() {
        return feature;
    }

    /**
     * Sets feature.
     *
     * @param feature the feature
     */
    public void setFeature(String feature) {
        this.feature = feature;
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
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
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
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets grade.
     *
     * @return the grade
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * Sets grade.
     *
     * @param grade the grade
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Gets solve type.
     *
     * @return the solve type
     */
    public Integer getSolveType() {
        return solveType;
    }

    /**
     * Sets solve type.
     *
     * @param solveType the solve type
     */
    public void setSolveType(Integer solveType) {
        this.solveType = solveType;
    }

    /**
     * Gets comment.
     *
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets comment.
     *
     * @param comment the comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
