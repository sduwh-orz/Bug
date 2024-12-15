package cn.edu.sdu.orz.bug.vo;


import java.io.Serializable;

public class UserQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String username;

    private String password;

    private String realName;

    private Integer role;

    private String email;

    private Integer deleted;

}
