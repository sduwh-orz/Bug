package cn.edu.sdu.orz.bug.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Bug vo.
 */
@Setter
@Getter
@SuppressWarnings("unused")
public class BugUpdateVO extends BugVO {
    private String id;

    private String description;

    private Integer status;

    private Integer solveType;

    private String comment;
}
