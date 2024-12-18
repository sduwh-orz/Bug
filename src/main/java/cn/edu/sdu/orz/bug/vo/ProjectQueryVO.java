package cn.edu.sdu.orz.bug.vo;


import java.io.Serializable;
import java.sql.Date;

public class ProjectQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private Integer page;

    private Integer size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
