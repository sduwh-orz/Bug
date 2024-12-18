package cn.edu.sdu.orz.bug.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "feature")
public class Feature implements Serializable {

    private static final long serialVersionUID = 1L;

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
    private List<Bug> bugs;

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

    @Override
    public String toString() {
        return "Feature{" +
                "id=" + id + '\'' +
                "name=" + name + '\'' +
                "module=" + (module != null ? module.getId() : null) + '\'' +
                "hours=" + hours + '\'' +
                "owner=" + (owner != null ? owner.getId() : null) + '\'' +
                '}';
    }
}
