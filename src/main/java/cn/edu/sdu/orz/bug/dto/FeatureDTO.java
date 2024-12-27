package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.Bug;
import cn.edu.sdu.orz.bug.entity.Feature;
import cn.edu.sdu.orz.bug.entity.Module;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * The type Feature dto.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class FeatureDTO extends FeatureBaseDTO {
    private String module;

    private Integer bugs = 0;

    /**
     * Sets module.
     *
     * @param module the module
     */
    public void setModule(Module module) {
        this.module = module.getId();
    }

    /**
     * Sets bugs.
     *
     * @param bugs the bugs
     */
    public void setBugs(List<Bug> bugs) {
        this.bugs = bugs.size();
    }

    /**
     * To dto feature dto.
     *
     * @param original the original
     * @return the feature dto
     */
    public static FeatureDTO toDTO(Feature original) {
        FeatureDTO bean = new FeatureDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }
}
