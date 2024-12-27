package cn.edu.sdu.orz.bug.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Project create vo.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class ProjectCreateVO extends ProjectVO {
    /**
     * The Keyword.
     */
    protected String keyword;

    /**
     * The Description.
     */
    protected String description;

    /**
     * The Owner.
     */
    protected String owner;
}
