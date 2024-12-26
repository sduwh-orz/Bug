package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.User;
import cn.edu.sdu.orz.bug.entity.UserRole;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Optional;

public class UserDTO implements Serializable {
    private String id;

    private String username;

    private String realName;

    private TypeDTO role;

    private String email;

    private Boolean isLeader;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public TypeDTO getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = TypeDTO.toDTO(role);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Optional<Boolean> isLeader() {
        return Optional.ofNullable(isLeader);
    }

    public void setLeader(Boolean leader) {
        isLeader = leader;
    }

    public static UserDTO toDTO(User original) {
        UserDTO bean = new UserDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }
}
