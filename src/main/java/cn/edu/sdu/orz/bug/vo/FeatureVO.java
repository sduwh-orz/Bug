package cn.edu.sdu.orz.bug.vo;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The type Feature vo.
 */
public class FeatureVO implements Serializable {

    private String name;

    private String module;

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
     * Gets module.
     *
     * @return the module
     */
    public String getModule() {
        return module;
    }

    /**
     * Sets module.
     *
     * @param module the module
     */
    public void setModule(String module) {
        this.module = module;
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
}
