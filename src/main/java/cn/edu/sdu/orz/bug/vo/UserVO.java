package cn.edu.sdu.orz.bug.vo;


import lombok.Getter;
import lombok.Setter;

/**
 * The type User vo.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class UserVO {
    /**
     * The Username.
     */
    protected String username;

    /**
     * The Real name.
     */
    protected String realName;

    /**
     * The Role.
     */
    protected Integer role;

    /**
     * The Email.
     */
    protected String email;
}
