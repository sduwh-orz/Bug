package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.User;
import cn.edu.sdu.orz.bug.entity.UserRole;
import org.springframework.beans.BeanUtils;

import java.util.Optional;

/**
 * The type User dto.
 */
@SuppressWarnings("unused")
public class UserDTO {
    private String id;

    private String username;

    private String realName;

    private TypeDTO role;

    private String email;

    private Boolean isLeader;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
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
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
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
     * Gets real name.
     *
     * @return the real name
     */
    public String getRealName() {
        return realName;
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
     * Gets role.
     *
     * @return the role
     */
    public TypeDTO getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(UserRole role) {
        this.role = TypeDTO.toDTO(role);
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
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Is leader optional.
     *
     * @return the optional
     */
    public Optional<Boolean> isLeader() {
        return Optional.ofNullable(isLeader);
    }

    /**
     * Sets leader.
     *
     * @param leader the leader
     */
    public void setLeader(Boolean leader) {
        isLeader = leader;
    }

    /**
     * To dto user dto.
     *
     * @param original the original
     * @return the user dto
     */
    public static UserDTO toDTO(User original) {
        UserDTO bean = new UserDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }
}
