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
    protected String name;

    protected BigDecimal hours;
}
