package com.zw.domain;

import java.io.Serializable;

public class RoleModuleKey implements Serializable {
    private Integer roleid;

    private Integer moduleid;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getModuleid() {
        return moduleid;
    }

    public void setModuleid(Integer moduleid) {
        this.moduleid = moduleid;
    }
    public RoleModuleKey(){
        // 无参构造
    }
    public RoleModuleKey(Integer roleid) {
        this.roleid = roleid;
    }
    public RoleModuleKey(Integer roleid, Integer moduleid) {
        this.roleid = roleid;
        this.moduleid = moduleid;
    }
}