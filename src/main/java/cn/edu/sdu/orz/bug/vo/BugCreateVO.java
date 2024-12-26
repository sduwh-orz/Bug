package cn.edu.sdu.orz.bug.vo;


/**
 * The type Bug create vo.
 */
public class BugCreateVO extends BugVO {
    private String description;

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
     * Instantiates a new Bug create vo.
     */
    public BugCreateVO() {
        super();
    }

    /**
     * Instantiates a new Bug create vo.
     *
     * @param description the description
     */
    public BugCreateVO(String description) {
        setDescription(description);
    }

    @Override
    public String toString() {
        return "BugCreateVO{" +
                "description='" + getDescription() + '\'' +
                '}';
    }
}
