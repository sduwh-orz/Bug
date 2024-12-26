package cn.edu.sdu.orz.bug.vo;


import java.io.Serializable;

/**
 * The type Bug query vo.
 */
public class BugQueryVO implements Serializable {

    private String id;

    private String name;

    private Integer grade;

    private String module;

    private String feature;

    private String developer;

    private String reporter;

    private Integer status;

    private Integer solveType;

    private Integer page;

    private Integer size;

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
     * Gets module.
     *
     * @return the module
     */
    public String getModule() {
        return module;
    }

    /**
     * Sets module.
     *
     * @param module the module
     */
    public void setModule(String module) {
        this.module = module;
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
     * Gets developer.
     *
     * @return the developer
     */
    public String getDeveloper() {
        return developer;
    }

    /**
     * Sets developer.
     *
     * @param developer the developer
     */
    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    /**
     * Gets reporter.
     *
     * @return the reporter
     */
    public String getReporter() {
        return reporter;
    }

    /**
     * Sets reporter.
     *
     * @param reporter the reporter
     */
    public void setReporter(String reporter) {
        this.reporter = reporter;
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
     * Gets page.
     *
     * @return the page
     */
    public Integer getPage() {
        return page;
    }

    /**
     * Sets page.
     *
     * @param page the page
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * Sets size.
     *
     * @param size the size
     */
    public void setSize(Integer size) {
        this.size = size;
    }
}
