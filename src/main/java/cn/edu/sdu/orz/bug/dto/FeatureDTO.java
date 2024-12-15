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

}
