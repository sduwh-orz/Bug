package cn.edu.sdu.orz.bug.vo;

public class ModuleCreateVO {

    private String projectId;

    private String name;

    public ModuleCreateVO(String projectId, String name) {
        this.projectId = projectId;
        this.name = name;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
