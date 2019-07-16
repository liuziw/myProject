package com.zw.reflect;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2019/5/17 10:17
 */
public class ExtendType extends Type {

    public int pubIntExtendField;
    public String pubStringExtendField;
    private int prvIntExtendField;

    public ExtendType() {
        log("Default Constructor");
    }

    ExtendType(int arg1, String arg2) {
        pubIntExtendField = arg1;
        pubStringExtendField = arg2;

        log("Constructor with parameters");
    }

    public void setIntExtendField(int field7) {
        this.prvIntExtendField = field7;
    }

    public int getIntExtendField() {
        return prvIntExtendField;
    }

    private void log(String msg) {
        System.out.println("ExtendType:" + msg);
    }
}
