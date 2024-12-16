package cn.edu.sdu.orz.bug.dto;

public class ProjectInBugListDTO {
    private String id;

    private String name;

    private String owner;

    private Long bugs;

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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Long getBugs() {
        return bugs;
    }

    public void setBugs(Long bugs) {
        this.bugs = bugs;
    }

    public ProjectInBugListDTO(String id, String name, String owner, Long bugs) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.bugs = bugs;
    }
}
