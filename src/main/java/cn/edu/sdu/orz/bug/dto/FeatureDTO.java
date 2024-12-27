package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.Bug;
import cn.edu.sdu.orz.bug.entity.Feature;
import cn.edu.sdu.orz.bug.entity.Module;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * The type Feature dto.
 */
@SuppressWarnings("unused")
public class FeatureDTO extends FeatureBaseDTO {

    private String module;

    private Integer bugs = 0;

    /**
     * Gets module.
     *
     * @return the module
     */
    public String getModule() {
        return module;
    }

    /**
     * Sets module.
     *
     * @param module the module
     */
    public void setModule(Module module) {
        this.module = module.getId();
    }

    /**
     * Gets bugs.
     *
     * @return the bugs
     */
    public Integer getBugs() {
        return bugs;
    }

    /**
     * Sets module.
     *
     * @param module the module
     */
    public void setModule(String module) {
        this.module = module;
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
