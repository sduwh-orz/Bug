package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.User;
import cn.edu.sdu.orz.bug.entity.UserRole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Optional;

/**
 * The type User dto.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class UserDTO extends UserBriefDTO {
    private String username;

    private TypeDTO role;

    private String email;

    private Boolean isLeader;

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(UserRole role) {
        this.role = TypeDTO.toDTO(role);
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
