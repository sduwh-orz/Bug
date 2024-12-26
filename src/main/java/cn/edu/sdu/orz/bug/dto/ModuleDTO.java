package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.Feature;
import cn.edu.sdu.orz.bug.entity.Module;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Module dto.
 */
public class ModuleDTO {

    private String id;

    private String name;

    private BigDecimal featureHoursSum;

    private List<FeatureDTO> features;

    /**
     * Gets features.
     *
     * @return the features
     */
    public List<FeatureDTO> getFeatures() {
        return features;
    }

    /**
     * Sets features.
     *
     * @param features the features
     */
    public void setFeatures(List<Feature> features) {
        this.features = features.stream().map(FeatureDTO::toDTO).collect(Collectors.toList());
    }

    /**
     * Gets feature hours sum.
     *
     * @return the feature hours sum
     */
    public BigDecimal getFeatureHoursSum() {
        return featureHoursSum;
    }

    /**
     * Sets feature hours sum.
     *
     * @param featureHoursSum the feature hours sum
     */
    public void setFeatureHoursSum(BigDecimal featureHoursSum) {
        this.featureHoursSum = featureHoursSum;
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
