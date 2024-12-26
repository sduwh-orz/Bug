package cn.edu.sdu.orz.bug.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "module")
public class Module implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "project", nullable = false)
    private Project project;

    @OneToMany(mappedBy = "module", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @OrderBy("name")
    private List<Feature> features;

    public Module() {
        super();
    }

    public Module(String id, String name, Project project, List<Feature> features) {
        setId(id);
        setName(name);
        setProject(project);
        setFeatures(features);
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public boolean hasNoPerm(User user) {
        return project.hasNoPerm(user);
    }

}
