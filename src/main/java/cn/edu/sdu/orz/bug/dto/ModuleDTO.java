package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.Feature;
import cn.edu.sdu.orz.bug.entity.Module;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Module dto.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class ModuleDTO extends BaseDTO {
    private BigDecimal featureHoursSum;

    private List<FeatureDTO> features;

    /**
     * Sets features.
     *
     * @param features the features
     */
    public void setFeatures(List<Feature> features) {
        this.features = features.stream().map(FeatureDTO::toDTO).collect(Collectors.toList());
    }

    /**
     * To dto module dto.
     *
     * @param original the original
     * @return the module dto
     */
    public static ModuleDTO toDTO(Module original) {
        ModuleDTO bean = new ModuleDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }
}
