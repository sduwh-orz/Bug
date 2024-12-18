package cn.edu.sdu.orz.bug.dto;

public class ProjectInTaskListDTO {
    private String id;

    private String name;

    private String owner;

    private Long totalFeatures;

    private Long totalDevelopers;


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

    public Long getTotalFeatures() {
        return totalFeatures;
    }

    public void setTotalFeatures(Long totalFeatures) {
        this.totalFeatures = totalFeatures;
    }

    public Long getTotalDevelopers() {
        return totalDevelopers;
    }

    public void setTotalDevelopers(Long developers) {
        this.totalDevelopers = developers;
    }

    public ProjectInTaskListDTO(String id, String name, String owner, Long totalFeatures, Long totalDevelopers) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.totalFeatures = totalFeatures;
        this.totalDevelopers = totalDevelopers;
    }
}
