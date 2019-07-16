package com.zw.reflect;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2019/5/17 10:14
 */
public class Type {

    public int pubIntField;
    public String pubStringField;
    private int prvIntField;

    public Type() {
        log("Default Constructor");
    }

    Type(int arg1, String arg2) {
        pubIntField = arg1;
        pubStringField = arg2;

        log("Constructor with parameters");
    }

    public void setIntField(int val) {
        this.prvIntField = val;
    }

    public int getIntField() {
        return prvIntField;
    }

    private void log(String msg) {
        System.out.println("Type:" + msg);
    }
}
