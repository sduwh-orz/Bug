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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public ProjectDTO() {
    }

    public ProjectDTO(String id, String name, String keyword, String description, String owner, Date created) {
        this.id = id;
        this.name = name;
        this.keyword = keyword;
        this.description = description;
        this.owner = owner;
        this.created = created;
    }
}
