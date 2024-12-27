package cn.edu.sdu.orz.bug.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * The type Feature vo.
 */
@Setter
@Getter
@SuppressWarnings("unused")
public class FeatureVO {
    private String name;

    private BigDecimal hours;

    /**
     * Instantiates a new Feature vo.
     */
    public FeatureVO() {
        super();
    }

    /**
     * Instantiates a new Feature vo.
     *
     * @param name  the name
     * @param hours the hours
     */
    public FeatureVO(String name, BigDecimal hours) {
        setName(name);
        setHours(hours);
    }
}
