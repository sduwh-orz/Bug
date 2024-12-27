package cn.edu.sdu.orz.bug.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * The type Feature.
 */
@Entity
@Table(name = "feature")
@Getter
@Setter
@SuppressWarnings("unused")
public class Feature {
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
     * Has no perm boolean.
     *
     * @param user the user
     * @return the boolean
     */
    public boolean hasNoPerm(User user) {
        return module.hasNoPerm(user);
    }
}
