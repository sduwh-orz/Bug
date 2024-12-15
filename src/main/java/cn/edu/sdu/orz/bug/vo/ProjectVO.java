package cn.edu.sdu.orz.bug.vo;


import java.io.Serializable;
import java.sql.Date;


public class ProjectVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String keyword;

    private String description;

    private String owner;

    private Date created;

}
