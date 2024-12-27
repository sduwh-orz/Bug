package cn.edu.sdu.orz.bug.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Module create vo.
 */
@Setter
@Getter
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
}
