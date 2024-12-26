package cn.edu.sdu.orz.bug.vo;


import java.io.Serializable;

/**
 * The type User create vo.
 */
public class UserCreateVO extends UserVO implements Serializable {

    private String password;

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
