package cn.edu.sdu.orz.bug.dto;

import java.io.Serializable;
import java.util.List;

public class ProjectBriefDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private List<ModuleBriefDTO> modules;

    public ProjectBriefDTO(String id, String name, List<ModuleBriefDTO> modules) {
        this.id = id;
        this.name = name;
        this.modules = modules;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ModuleBriefDTO> getModules() {
        return modules;
    }

    public void setModules(List<ModuleBriefDTO> modules) {
        this.modules = modules;
    }
}
