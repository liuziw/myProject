package com.zw.reflect.springTest;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2019/5/17 14:54
 */
public class JavaBean {
    private String userName;
    private String password;

    public String getPassword() {
        return password;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
