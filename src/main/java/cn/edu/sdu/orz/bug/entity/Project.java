package cn.edu.sdu.orz.bug.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

/**
 * The type Project.
 */
@Entity
@Table(name = "project")
@Getter
@Setter
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
     * Has no perm boolean.
     *
     * @param user the user
     * @return the boolean
     */
    public boolean hasNoPerm(User user) {
        return !owner.getId().equals(user.getId()) && !user.isAdmin();
    }
}
