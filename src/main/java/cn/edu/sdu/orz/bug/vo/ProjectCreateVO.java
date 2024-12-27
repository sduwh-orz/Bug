package cn.edu.sdu.orz.bug.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Project create vo.
 */
@Setter
@Getter
@SuppressWarnings("unused")
public class ProjectCreateVO extends ProjectVO {
    private String keyword;

    private String description;

    private String owner;
}
