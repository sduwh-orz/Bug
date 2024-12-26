package cn.edu.sdu.orz.bug.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

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

    public Feature() {
        super();
    }

    public Feature(String id, String name, BigDecimal hours, Module module, User owner, List<Bug> bugs) {
        setId(id);
        setName(name);
        setHours(hours);
        setModule(module);
        setOwner(owner);
        setBugs(bugs);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Module getModule() {
        return module;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }

    public BigDecimal getHours() {
        return hours;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Bug> getBugs() {
        return bugs;
    }

    public void setBugs(List<Bug> bugs) {
        this.bugs = bugs;
    }

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
