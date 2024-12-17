package cn.edu.sdu.orz.bug.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class FeatureBriefDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private BigDecimal hours;

    public FeatureBriefDTO(String id, String name, BigDecimal hours) {
        this.id = id;
        this.name = name;
        this.hours = hours;
    }

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

    public BigDecimal getHours() {
        return hours;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }
}
