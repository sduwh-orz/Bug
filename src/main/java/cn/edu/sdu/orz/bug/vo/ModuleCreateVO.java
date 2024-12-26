package cn.edu.sdu.orz.bug.vo;

/**
 * The type Module create vo.
 */
@SuppressWarnings("unused")
public class ModuleCreateVO extends ModuleVO {

    private String projectId;

    /**
     * Instantiates a new Module create vo.
     */
    public ModuleCreateVO() {
        super();
    }

    /**
     * Instantiates a new Module create vo.
     *
     * @param projectId the project id
     * @param name      the name
     */
    public ModuleCreateVO(String projectId, String name) {
        setProjectId(projectId);
        setName(name);
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
}
