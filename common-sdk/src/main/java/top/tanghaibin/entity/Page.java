package top.tanghaibin.entity;

import java.util.ArrayList;

/**
 * Created by 唐海斌 on 2016/8/25.
 *
 * 分页实体
 */
public class Page<T> extends ArrayList<T>{

    private long pageNow;
    private long pageSize;
    private long total;

    public long getPageNow() {
        return pageNow;
    }

    public void setPageNow(long pageNow) {
        this.pageNow = pageNow;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
