package cn.edu.sdu.orz.bug.vo;


/**
 * The type Bug vo.
 */
public class BugUpdateVO extends BugVO {

    private String id;

    private String description;

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

    /**
     * Instantiates a new Bug update vo.
     */
    public BugUpdateVO() {
        super();
    }

    /**
     * Instantiates a new Bug update vo.
     *
     * @param id          the id
     * @param description the description
     * @param status      the status
     * @param solveType   the solve type
     * @param comment     the comment
     */
    public BugUpdateVO(String id, String description, Integer status, Integer solveType, String comment) {
        setId(id);
        setDescription(description);
        setStatus(status);
        setSolveType(solveType);
        setComment(comment);
    }

    @Override
    public String toString() {
        return "BugUpdateVO{" +
                "id='" + getId() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", status=" + getStatus() +
                ", solveType=" + getSolveType() +
                ", comment='" + getComment() + '\'' +
                '}';
    }
}
