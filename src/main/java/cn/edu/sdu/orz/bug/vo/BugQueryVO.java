package cn.edu.sdu.orz.bug.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Bug query vo.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class BugQueryVO extends BugVO {
    private String id;

    private String module;

    private String developer;

    private String reporter;

    private Integer status;

    private Integer solveType;

    private Integer page;

    private Integer size;
}
