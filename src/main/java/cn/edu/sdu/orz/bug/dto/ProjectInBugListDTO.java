package cn.edu.sdu.orz.bug.dto;

/**
 * The type Project in bug list dto.
 */
public class ProjectInBugListDTO {
    private String id;

    private String name;

    private String owner;

    private Long bugs;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

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
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.bugs = bugs;
    }
}
