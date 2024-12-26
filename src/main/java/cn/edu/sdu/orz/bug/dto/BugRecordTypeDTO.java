package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.BugRecordType;
import org.springframework.beans.BeanUtils;

/**
 * The type Bug record type dto.
 */
public class BugRecordTypeDTO {
    private String id;

    private String name;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
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
     * To dto bug record type dto.
     *
     * @param original the original
     * @return the bug record type dto
     */
    public static BugRecordTypeDTO toDTO(BugRecordType original) {
        BugRecordTypeDTO bean = new BugRecordTypeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }
}
