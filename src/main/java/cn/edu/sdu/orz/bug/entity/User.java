package cn.edu.sdu.orz.bug.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The type User.
 */
@Entity
@Table(name = "user")
@Getter
@Setter
@SuppressWarnings("unused")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "real_name", nullable = false)
    private String realName;

    @ManyToOne
    @JoinColumn(name = "role", nullable = false)
    private UserRole role;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "deleted", nullable = false)
    private Integer deleted;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Feature> features;

    /**
     * Return if the User is admin.
     *
     * @return the boolean
     */
    public boolean isAdmin() {
        return this.role.getName().equals("管理员");
    }

}
