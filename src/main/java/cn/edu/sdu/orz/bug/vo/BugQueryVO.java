package cn.edu.sdu.orz.bug.vo;


/**
 * The type Bug query vo.
 */
public class BugQueryVO extends BugVO {

    private String id;

    private String module;

    private String developer;

    private String reporter;

    private Integer status;

    private Integer solveType;

    private Integer page;

    private Integer size;

    /**
     * Instantiates a new Bug query vo.
     */
    public BugQueryVO() {
        super();
    }

    /**
     * Instantiates a new Bug query vo.
     *
     * @param id        the id
     * @param module    the module
     * @param developer the developer
     * @param reporter  the reporter
     * @param status    the status
     * @param solveType the solve type
     * @param page      the page
     * @param size      the size
     */
    public BugQueryVO(String id, String module, String developer, String reporter, Integer status, Integer solveType,
                      Integer page, Integer size) {
        setId(id);
        setModule(module);
        setDeveloper(developer);
        setReporter(reporter);
        setStatus(status);
        setSolveType(solveType);
        setPage(page);
        setSize(size);
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
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
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
