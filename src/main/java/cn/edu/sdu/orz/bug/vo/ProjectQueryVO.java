package cn.edu.sdu.orz.bug.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Project query vo.
 */
@Getter
@Setter
@SuppressWarnings("unused")
public class ProjectQueryVO extends ProjectVO {
    private Integer page;

    private Integer size;
}
