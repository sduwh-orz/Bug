package cn.edu.sdu.orz.bug.vo;


import java.io.Serializable;

public class UserCreateVO extends UserVO implements Serializable {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
