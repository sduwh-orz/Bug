package cn.edu.sdu.orz.bug.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class FeatureUpdateVO implements Serializable {

    private String id;

    private String name;

    private String owner;

    private BigDecimal hours;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BigDecimal getHours() {
        return hours;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }
}
