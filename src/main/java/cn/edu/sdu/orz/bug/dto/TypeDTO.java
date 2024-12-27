package cn.edu.sdu.orz.bug.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

/**
 * The Type dto.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class TypeDTO {
    private Integer id;

    private String name;

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
