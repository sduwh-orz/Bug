package cn.edu.sdu.orz.bug.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "project")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "keyword", nullable = false)
    private String keyword;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "owner", nullable = false)
    private String owner;

    @Column(name = "created", nullable = false)
    private Date created;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id + '\'' +
                "name=" + name + '\'' +
                "keyword=" + keyword + '\'' +
                "description=" + description + '\'' +
                "owner=" + owner + '\'' +
                "created=" + created + '\'' +
                '}';
    }
}
