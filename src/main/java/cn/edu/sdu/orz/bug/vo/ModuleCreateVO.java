package cn.edu.sdu.orz.bug.vo;

/**
 * The type Module create vo.
 */
public class ModuleCreateVO {

    private String projectId;

    private String name;

    /**
     * Instantiates a new Module create vo.
     *
     * @param projectId the project id
     * @param name      the name
     */
    public ModuleCreateVO(String projectId, String name) {
        this.projectId = projectId;
        this.name = name;
    }

    /**
     * Gets project id.
     *
     * @return the project id
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * Sets project id.
     *
     * @param projectId the project id
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
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
}
