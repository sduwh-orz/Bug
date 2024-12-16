package cn.edu.sdu.orz.bug.dto;


import java.io.Serializable;
import java.math.BigDecimal;

public class FeatureDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;

    private String name;

    private String module;

    private BigDecimal hours;

    private String owner;

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

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public BigDecimal getHours() {
        return hours;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
