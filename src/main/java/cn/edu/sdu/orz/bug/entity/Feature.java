package cn.edu.sdu.orz.bug.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * The type Feature.
 */
@Entity
@Table(name = "feature")
public class Feature implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "hours", nullable = false)
    private BigDecimal hours;

    @ManyToOne
    @JoinColumn(name = "module", nullable = false)
    private Module module;

    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;

    @OneToMany(mappedBy = "feature", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @OrderBy("name")
    private List<Bug> bugs;

    /**
     * Instantiates a new Feature.
     */
    public Feature() {
        super();
    }

    /**
     * Instantiates a new Feature.
     *
     * @param id     the id
     * @param name   the name
     * @param hours  the hours
     * @param module the module
     * @param owner  the owner
     * @param bugs   the bugs
     */
    public Feature(String id, String name, BigDecimal hours, Module module, User owner, List<Bug> bugs) {
        setId(id);
        setName(name);
        setHours(hours);
        setModule(module);
        setOwner(owner);
        setBugs(bugs);
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
     * Sets module.
     *
     * @param module the module
     */
    public void setModule(Module module) {
        this.module = module;
    }

    /**
     * Gets module.
     *
     * @return the module
     */
    public Module getModule() {
        return module;
    }

    /**
     * Sets hours.
     *
     * @param hours the hours
     */
    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }

    /**
     * Gets hours.
     *
     * @return the hours
     */
    public BigDecimal getHours() {
        return hours;
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
     * Sets owner.
     *
     * @param owner the owner
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }

    /**
     * Gets bugs.
     *
     * @return the bugs
     */
    public List<Bug> getBugs() {
        return bugs;
    }

    /**
     * Sets bugs.
     *
     * @param bugs the bugs
     */
    public void setBugs(List<Bug> bugs) {
        this.bugs = bugs;
    }

    /**
     * Has no perm boolean.
     *
     * @param user the user
     * @return the boolean
     */
    public boolean hasNoPerm(User user) {
        return module.hasNoPerm(user);
    }

    @Override
    public String toString() {
        return "Feature{" +
                "id=" + getId() + '\'' +
                "name=" + getName() + '\'' +
                "module=" + (module != null ? module.getId() : null) + '\'' +
                "hours=" + getHours() + '\'' +
                "owner=" + (owner != null ? owner.getId() : null) + '\'' +
                "bugs=" + getBugs() +
                '}';
    }
}
