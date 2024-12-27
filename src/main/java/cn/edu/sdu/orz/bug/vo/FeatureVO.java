package cn.edu.sdu.orz.bug.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * The type Feature vo.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class FeatureVO {
    /**
     * The Name.
     */
    protected String name;

    /**
     * The Hours.
     */
    protected BigDecimal hours;
}
