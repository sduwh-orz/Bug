package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.Feature;
import cn.edu.sdu.orz.bug.entity.Module;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

/**
 * The type Bug feature dto.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class BugFeatureDTO extends FeatureBaseDTO {
    private BugModuleDTO module;

    /**
     * Sets module.
     *
     * @param module the module
     */
    public void setModule(Module module) {
        this.module = BugModuleDTO.toDTO(module);
    }

    /**
     * To dto bug feature dto.
     *
     * @param original the original
     * @return the bug feature dto
     */
    public static BugFeatureDTO toDTO(Feature original) {
        BugFeatureDTO bean = new BugFeatureDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }
}
