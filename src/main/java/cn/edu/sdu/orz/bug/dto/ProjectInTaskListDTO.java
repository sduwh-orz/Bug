package cn.edu.sdu.orz.bug.dto;

/**
 * The type Project in task list dto.
 */
@SuppressWarnings("unused")
public class ProjectInTaskListDTO extends ProjectBaseDTO {
    private String owner;

    private Long totalFeatures;

    private Long totalDevelopers;

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
     * Gets total features.
     *
     * @return the total features
     */
    public Long getTotalFeatures() {
        return totalFeatures;
    }

    /**
     * Sets total features.
     *
     * @param totalFeatures the total features
     */
    public void setTotalFeatures(Long totalFeatures) {
        this.totalFeatures = totalFeatures;
    }

    /**
     * Gets total developers.
     *
     * @return the total developers
     */
    public Long getTotalDevelopers() {
        return totalDevelopers;
    }

    /**
     * Sets total developers.
     *
     * @param developers the developers
     */
    public void setTotalDevelopers(Long developers) {
        this.totalDevelopers = developers;
    }

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
