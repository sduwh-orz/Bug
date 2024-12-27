package cn.edu.sdu.orz.bug.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Project in bug list dto.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class ProjectInBugListDTO extends BaseDTO {
    private String owner;
    private Long bugs;

    /**
     * Instantiates a new Project in bug list dto.
     *
     * @param id    the id
     * @param name  the name
     * @param owner the owner
     * @param bugs  the bugs
     */
    public ProjectInBugListDTO(String id, String name, String owner, Long bugs) {
        setId(id);
        setName(name);
        setOwner(owner);
        setBugs(bugs);
    }
}
