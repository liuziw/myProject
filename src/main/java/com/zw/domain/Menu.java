package com.zw.domain;

import java.util.List;

/**
 * Created by hcf on 2017/8/22.
 */
public class Menu {
    private Integer id;
    private String name;
    private String url;
    private List<Menu> child;

    public Menu(){

    }

    public Menu(Integer id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url==null?"":url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Menu> getChild() {
        return child;
    }

    public void setChild(List<Menu> child) {
        this.child = child;
    }
}
