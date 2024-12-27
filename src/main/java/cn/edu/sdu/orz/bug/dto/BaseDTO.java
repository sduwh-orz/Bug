package cn.edu.sdu.orz.bug.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

/**
 * The type Project base dto.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class BaseDTO {
    /**
     * The ID.
     */
    protected String id;

    /**
     * The Name.
     */
    protected String name;

    /**
     * To dto base dto.
     *
     * @param <T>      the type parameter
     * @param original the original
     * @return the base dto
     */
    public static <T> BaseDTO toDTO(T original) {
        BaseDTO bean = new BaseDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }
}
