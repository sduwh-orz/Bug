package cn.edu.sdu.orz.bug.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * The type Task assign vo.
 */
@Setter
@Getter
@SuppressWarnings("unused")
public class TaskAssignVO {
    private String projectId;

    private Map<String, Map<String, TaskAssignFeatureVO>> modules;
}
