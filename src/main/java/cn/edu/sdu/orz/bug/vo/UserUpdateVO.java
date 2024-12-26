package cn.edu.sdu.orz.bug.vo;


import java.io.Serializable;

/**
 * The type User update vo.
 */
public class UserUpdateVO extends UserVO implements Serializable {

    private String id;

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
}
