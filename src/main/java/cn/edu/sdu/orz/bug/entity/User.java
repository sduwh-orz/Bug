package cn.edu.sdu.orz.bug.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 * The type User.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

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
     * Instantiates a new User.
     */
    public User() {
        super();
    }

    /**
     * Instantiates a new User.
     *
     * @param id       the id
     * @param username the username
     * @param password the password
     * @param realName the real name
     * @param role     the role
     * @param email    the email
     * @param deleted  the deleted
     * @param features the features
     */
    public User(String id, String username, String password, String realName, UserRole role, String email,
                Integer deleted, List<Feature> features) {
        setId(id);
        setUsername(username);
        setPassword(password);
        setRealName(realName);
        setRole(role);
        setEmail(email);
        setDeleted(deleted);
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
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets real name.
     *
     * @param realName the real name
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * Gets real name.
     *
     * @return the real name
     */
    public String getRealName() {
        return realName;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public UserRole getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(UserRole role) {
        this.role = role;
    }

    /**
     * Return if the User is admin.
     *
     * @return the boolean
     */
    public boolean isAdmin() {
        return this.role.getName().equals("管理员");
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets deleted.
     *
     * @param deleted the deleted
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * Gets deleted.
     *
     * @return the deleted
     */
    public Integer getDeleted() {
        return deleted;
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

    @Override
    public String toString() {
        return "User{" +
                "id='" + getId() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", realName='" + getRealName() + '\'' +
                ", role=" + getRole().getName() +
                ", email='" + getEmail() + '\'' +
                ", deleted=" + getDeleted() +
                ", features=" + getFeatures() +
                '}';
    }
}
