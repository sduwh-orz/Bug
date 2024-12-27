package cn.edu.sdu.orz.bug.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * The type User role.
 */
@Entity
@Table(name = "user_role")
@SuppressWarnings("unused")
public class UserRole extends Type {

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
        setId(id);
    }

}
