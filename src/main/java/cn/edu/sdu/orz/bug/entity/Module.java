package cn.edu.sdu.orz.bug.entity;

import jakarta.persistence.*;

import java.util.List;

/**
 * The type Module.
 */
@Entity
@Table(name = "module")
public class Module {

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

    /**
     * Instantiates a new Module.
     */
    public Module() {
        super();
    }

    /**
     * Instantiates a new Module.
     *
     * @param id       the id
     * @param name     the name
     * @param project  the project
     * @param features the features
     */
    public Module(String id, String name, Project project, List<Feature> features) {
        setId(id);
        setName(name);
        setProject(project);
        setFeatures(features);
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
     * Gets project.
     *
     * @return the project
     */
    public Project getProject() {
        return project;
    }

    /**
     * Sets project.
     *
     * @param project the project
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * Gets features.
     *
     * @return the features
     */
    public List<Feature> getFeatures() {
        return features;
    }

    /**
     * Sets features.
     *
     * @param features the features
     */
    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    /**
     * Has no perm boolean.
     *
     * @param user the user
     * @return the boolean
     */
    public boolean hasNoPerm(User user) {
        return project.hasNoPerm(user);
    }

}
