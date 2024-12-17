package cn.edu.sdu.orz.bug.vo;


import java.io.Serializable;

public class UserPasswordVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String previous;

    private String password;

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
