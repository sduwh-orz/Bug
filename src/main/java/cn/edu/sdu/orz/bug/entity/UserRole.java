package cn.edu.sdu.orz.bug.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The type User role.
 */
@Entity
@Table(name = "user_role")
public class UserRole {


    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Instantiates a new User role.
     */
    public UserRole() {
        super();
    }

    /**
     * Instantiates a new User role.
     *
     * @param id the id
     */
    public UserRole(Integer id) {
        this.id = id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
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

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id + '\'' +
                "name=" + name + '\'' +
                '}';
    }
}
