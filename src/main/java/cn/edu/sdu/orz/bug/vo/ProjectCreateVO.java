package cn.edu.sdu.orz.bug.vo;

public class ProjectCreateVO {
    private String name;

    private String keyword;

    private String description;

    private String owner;

    public ProjectCreateVO(String name, String keyword, String description, String owner) {
        this.name = name;
        this.keyword = keyword;
        this.description = description;
        this.owner = owner;
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
}
