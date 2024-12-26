package cn.edu.sdu.orz.bug.dto;

import java.io.Serializable;

public class StatsDTO implements Serializable {

    private String name;

    private String count;

    public StatsDTO() {
    }

    public StatsDTO(String name, String count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
