package cn.edu.sdu.orz.bug.dto;

/**
 * The type Project in bug list dto.
 */
@SuppressWarnings("unused")
public class ProjectInBugListDTO extends ProjectBaseDTO {
    private String owner;

    private Long bugs;

    /**
     * Gets owner.
     *
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets owner.
     *
     * @param owner the owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Gets bugs.
     *
     * @return the bugs
     */
    public Long getBugs() {
        return bugs;
    }

    /**
     * Sets bugs.
     *
     * @param bugs the bugs
     */
    public void setBugs(Long bugs) {
        this.bugs = bugs;
    }

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
