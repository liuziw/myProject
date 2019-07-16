package com.zw.common;

/**
 * Created by hcf on 2017/9/1.
 */
public enum UserStateEnum {
    normal("正常",0),
    locked("锁定",1);

    private Integer value;

    private String name;

    /** Internal constructor */
    UserStateEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static String getNameByValue(Integer value){
        String name = null;
        for (UserStateEnum tempEnum : UserStateEnum.values()) {
            if (tempEnum.getValue().equals(value)) {
                name=tempEnum.getName();
                break;
            }
        }
        return name;
    }

    public static UserStateEnum getStateEnum(String value) {
        UserStateEnum stateEnum = null;
        for (UserStateEnum tempEnum : UserStateEnum.values()) {
            if (tempEnum.getValue().equals(value)) {
                stateEnum = tempEnum;
                break;
            }
        }
        return stateEnum;
    }
}
