package cn.edu.sdu.orz.bug.dto;


import java.io.Serializable;

public class UserBriefDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;

    private String realName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
