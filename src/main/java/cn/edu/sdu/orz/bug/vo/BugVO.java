package cn.edu.sdu.orz.bug.vo;

/**
 * The type Bug vo.
 */
public class BugVO {
    private String name;

    private Integer grade;

    private String feature;

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
     * Instantiates a new Bug vo.
     */
    public BugVO() {
        super();
    }

    /**
     * Instantiates a new Bug vo.
     *
     * @param name    the name
     * @param grade   the grade
     * @param feature the feature
     */
    public BugVO(String name, Integer grade, String feature) {
        setName(name);
        setGrade(grade);
        setFeature(feature);
    }
}
