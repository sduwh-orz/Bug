package cn.edu.sdu.orz.bug.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "project")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getOwner() {
        return owner;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getCreated() {
        return created;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public boolean hasNoPerm(User user) {
        return !owner.getId().equals(user.getId()) && !user.isAdmin();
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id + '\'' +
                "name=" + name + '\'' +
                "keyword=" + keyword + '\'' +
                "description=" + description + '\'' +
                "owner=" + owner + '\'' +
                "created=" + created + '\'' +
                '}';
    }
}
