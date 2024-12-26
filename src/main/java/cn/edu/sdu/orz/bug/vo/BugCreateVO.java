package cn.edu.sdu.orz.bug.vo;


import java.io.Serializable;


/**
 * The type Bug create vo.
 */
public class BugCreateVO implements Serializable {

    private String name;

    private Integer grade;

    private String feature;

    private String description;

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
}
