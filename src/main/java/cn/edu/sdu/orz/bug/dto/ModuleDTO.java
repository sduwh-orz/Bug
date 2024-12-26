package cn.edu.sdu.orz.bug.dto;

import cn.edu.sdu.orz.bug.entity.Feature;
import cn.edu.sdu.orz.bug.entity.Module;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ModuleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private BigDecimal featureHoursSum;

    private List<FeatureDTO> features;

    public List<FeatureDTO> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features.stream().map(FeatureDTO::toDTO).collect(Collectors.toList());
    }

    public BigDecimal getFeatureHoursSum() {
        return featureHoursSum;
    }

    public void setFeatureHoursSum(BigDecimal featureHoursSum) {
        this.featureHoursSum = featureHoursSum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static ModuleDTO toDTO(Module original) {
        ModuleDTO bean = new ModuleDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }
}
