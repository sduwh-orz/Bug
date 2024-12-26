package cn.edu.sdu.orz.bug.dto;

/**
 * The type Stats dto.
 */
@SuppressWarnings("unused")
public class StatsDTO {

    private String name;

    private String count;

    /**
     * Instantiates a new Stats dto.
     */
    public StatsDTO() {
    }

    /**
     * Instantiates a new Stats dto.
     *
     * @param name  the name
     * @param count the count
     */
    public StatsDTO(String name, String count) {
        this.name = name;
        this.count = count;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    public String getCount() {
        return count;
    }

    /**
     * Sets count.
     *
     * @param count the count
     */
    public void setCount(String count) {
        this.count = count;
    }
}
