package cn.edu.sdu.orz.bug.dto;

import org.springframework.beans.BeanUtils;

/**
 * The Type dto.
 */
@SuppressWarnings("unused")
public class TypeDTO {
    private Integer id;

    private String name;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
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
     * To dto type dto.
     *
     * @param type the type
     * @return the type dto
     */
    public static TypeDTO toDTO(Object type) {
        TypeDTO bean = new TypeDTO();
        BeanUtils.copyProperties(type, bean);
        return bean;
    }
}
