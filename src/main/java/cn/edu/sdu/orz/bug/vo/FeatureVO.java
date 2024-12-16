package cn.edu.sdu.orz.bug.vo;

import java.io.Serializable;
import java.math.BigDecimal;


public class FeatureVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private String module;

    private BigDecimal hours;

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
}
