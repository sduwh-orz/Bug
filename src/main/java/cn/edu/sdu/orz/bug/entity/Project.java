package cn.edu.sdu.orz.bug.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * The type Project.
 */
@Entity
@Table(name = "project")
@SuppressWarnings("unused")
public class Project {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "keyword", nullable = false)
    private String keyword;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "owner", nullable = false)
    private User owner;

    @Column(name = "created", nullable = false)
    private Timestamp created;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("name")
    private List<Module> modules;

    /**
     * Instantiates a new Project.
     */
    public Project() {
        super();
    }

    /**
     * Instantiates a new Project.
     *
     * @param id          the id
     * @param name        the name
     * @param keyword     the keyword
     * @param description the description
     * @param owner       the owner
     * @param created     the created
     * @param modules     the modules
     */
    public Project(String id, String name, String keyword, String description, User owner, Timestamp created,
                   List<Module> modules) {
        setId(id);
        setName(name);
        setKeyword(keyword);
        setDescription(description);
        setOwner(owner);
        setCreated(created);
        setModules(modules);
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
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets keyword.
     *
     * @param keyword the keyword
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Gets keyword.
     *
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets owner.
     *
     * @param owner the owner
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }

    /**
     * Gets owner.
     *
     * @return the owner
     */
    public User getOwner() {
        return owner;
    }

    /**
     * Sets created.
     *
     * @param created the created
     */
    public void setCreated(Timestamp created) {
        this.created = created;
    }

    /**
     * Gets created.
     *
     * @return the created
     */
    public Timestamp getCreated() {
        return created;
    }

    /**
     * Gets modules.
     *
     * @return the modules
     */
    public List<Module> getModules() {
        return modules;
    }

    /**
     * Sets modules.
     *
     * @param modules the modules
     */
    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    /**
     * Has no perm boolean.
     *
     * @param user the user
     * @return the boolean
     */
    public boolean hasNoPerm(User user) {
        return !owner.getId().equals(user.getId()) && !user.isAdmin();
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + getId() + '\'' +
                "name=" + getName() + '\'' +
                "keyword=" + getKeyword() + '\'' +
                "description=" + getDescription() + '\'' +
                "owner=" + getOwner() + '\'' +
                "created=" + getCreated() + '\'' +
                "modules=" + getModules() + '\'' +
                '}';
    }
}
