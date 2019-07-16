package com.zw.util;

import java.util.List;

/**
 * Created by hcf on 2017/8/15.
 */
public class DataList<T> {
    private Pager pager;
    private List<T> list;

    public DataList(Pager pager, List<T> list) {
        this.pager = pager;
        this.list = list;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
