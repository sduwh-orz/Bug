package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.BugRecordType;
import org.springframework.beans.BeanUtils;

public class BugRecordTypeDTO {
    private String id;

    private String name;

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

    public static BugRecordTypeDTO toDTO(BugRecordType original) {
        BugRecordTypeDTO bean = new BugRecordTypeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }
}
