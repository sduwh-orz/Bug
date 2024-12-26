package cn.edu.sdu.orz.bug.vo;


/**
 * The type User query vo.
 */
@SuppressWarnings("unused")
public class UserQueryVO extends UserVO {

    private Integer page;

    private Integer size;

    /**
     * Gets page.
     *
     * @return the page
     */
    public Integer getPage() {
        return page;
    }

    /**
     * Sets page.
     *
     * @param page the page
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * Sets size.
     *
     * @param size the size
     */
    public void setSize(Integer size) {
        this.size = size;
    }
}
