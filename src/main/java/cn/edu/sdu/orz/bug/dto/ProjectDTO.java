package cn.edu.sdu.orz.bug.dto;


import java.io.Serializable;
import java.sql.Date;

public class ProjectDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;

    private String name;

    private String keyword;

    private String description;

    private String owner;

    private Date created;

}
