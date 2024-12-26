package cn.edu.sdu.orz.bug.vo;

import java.math.BigDecimal;

/**
 * The type Feature vo.
 */
@SuppressWarnings("unused")
public class FeatureVO {
    private String name;

    private BigDecimal hours;

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets hours.
     *
     * @return the hours
     */
    public BigDecimal getHours() {
        return hours;
    }

    /**
     * Sets hours.
     *
     * @param hours the hours
     */
    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }

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
