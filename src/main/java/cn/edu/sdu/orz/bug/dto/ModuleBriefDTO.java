package cn.edu.sdu.orz.bug.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ModuleBriefDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private BigDecimal featureHoursSum;

    private List<FeatureBriefDTO> features;

    public ModuleBriefDTO(String id, String name, BigDecimal featureHoursSum, List<FeatureBriefDTO> features) {
        this.id = id;
        this.name = name;
        this.featureHoursSum = featureHoursSum;
        this.features = features;
    }

    public List<FeatureBriefDTO> getFeatures() {
        return features;
    }

    public void setFeatures(List<FeatureBriefDTO> features) {
        this.features = features;
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
}
