package cn.edu.sdu.orz.bug.dto;


import org.springframework.beans.BeanUtils;

import java.io.Serializable;

public class TypeDTO implements Serializable {
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static TypeDTO toDTO(Object type) {
        TypeDTO bean = new TypeDTO();
        BeanUtils.copyProperties(type, bean);
        return bean;
    }
}
