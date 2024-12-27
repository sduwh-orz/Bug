package cn.edu.sdu.orz.bug.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Project in task list dto.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class ProjectInTaskListDTO extends BaseDTO {
    private String owner;

    private Long totalFeatures;

    private Long totalDevelopers;

    /**
     * Instantiates a new Project in task list dto.
     *
     * @param id              the id
     * @param name            the name
     * @param owner           the owner
     * @param totalFeatures   the total features
     * @param totalDevelopers the total developers
     */
    public ProjectInTaskListDTO(String id, String name, String owner, Long totalFeatures, Long totalDevelopers) {
        setId(id);
        setName(name);
        setOwner(owner);
        setTotalFeatures(totalFeatures);
        setTotalDevelopers(totalDevelopers);
    }
}
