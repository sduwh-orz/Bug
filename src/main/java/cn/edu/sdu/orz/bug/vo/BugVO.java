package cn.edu.sdu.orz.bug.vo;


import java.io.Serializable;
import java.sql.Date;


public class BugVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String feature;

    private String name;

    private String description;

    private Integer grade;

    private String reporter;

    private Integer status;

    private Integer solveType;

    private Date created;

    private Date modified;

}
