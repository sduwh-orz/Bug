package cn.edu.sdu.orz.bug.vo;


import java.io.Serializable;
import java.sql.Date;


public class BugRecordVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String bug;

    private Integer type;

    private Integer previous;

    private Integer after;

    private Integer solveType;

    private String comment;

    private String user;

    private Date time;

}
