package cn.edu.sdu.orz.bug.vo;

import java.io.Serializable;
import java.util.Map;

/**
 * The type Task assign vo.
 */
public class TaskAssignVO implements Serializable {

    private String projectId;

    private Map<String, Map<String, TaskAssignFeatureVO>> modules;

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
     * @param id the id
     */
    public void setProjectId(String id) {
        this.projectId = id;
    }

    /**
     * Gets modules.
     *
     * @return the modules
     */
    public Map<String, Map<String, TaskAssignFeatureVO>> getModules() {
        return modules;
    }

    /**
     * Sets modules.
     *
     * @param modules the modules
     */
    public void setModules(Map<String, Map<String, TaskAssignFeatureVO>> modules) {
        this.modules = modules;
    }
}
