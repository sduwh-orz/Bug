package cn.edu.sdu.orz.bug.vo;


import java.io.Serializable;
import java.math.BigDecimal;

public class FeatureQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String module;

    private BigDecimal hours;

    private String owner;

}
