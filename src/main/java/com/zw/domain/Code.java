package com.zw.domain;

import lombok.Data;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2019/4/28 16:16
 */
public class Code {
    private Long id;

    private String code;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
