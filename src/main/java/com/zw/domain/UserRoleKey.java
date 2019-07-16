package com.zw.domain;

import java.io.Serializable;

public class UserRoleKey implements Serializable {
    private Integer userid;

    private Integer roleid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public UserRoleKey(){
        // 无参构造
    }
    public UserRoleKey(Integer roleid) {
        this.roleid = roleid;
    }
    public UserRoleKey(Integer userid, Integer roleid) {
        this.userid = userid;
        this.roleid = roleid;
    }
}