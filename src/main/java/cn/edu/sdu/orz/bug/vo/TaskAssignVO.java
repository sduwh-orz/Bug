package cn.edu.sdu.orz.bug.vo;

import java.io.Serializable;
import java.util.Map;

public class TaskAssignVO implements Serializable {

    private String projectId;

    private Map<String, Map<String, TaskAssignFeatureVO>> modules;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String id) {
        this.projectId = id;
    }

    public Map<String, Map<String, TaskAssignFeatureVO>> getModules() {
        return modules;
    }

    public void setModules(Map<String, Map<String, TaskAssignFeatureVO>> modules) {
        this.modules = modules;
    }
}
