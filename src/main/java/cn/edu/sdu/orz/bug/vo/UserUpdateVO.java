package cn.edu.sdu.orz.bug.vo;


import java.io.Serializable;

public class UserUpdateVO extends UserVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
