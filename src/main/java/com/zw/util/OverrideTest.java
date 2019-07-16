package com.zw.util;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2019/4/24 16:09
 */
public class OverrideTest {

    static class Human{}
    static class Man extends Human{}
    static class Woman extends Human{}

    public void say(Human guy){
        System.out.println("hellow,guy");
    }
    public void say(Man man){
        System.out.println("hellow,man");
    }
    public void say(Woman woman){
        System.out.println("hellow,woman");
    }

    public static void main(String [] args){
        Human man = new Man();
        Human woman = new Woman();
        OverrideTest ot = new OverrideTest();
        ot.say(man);
        ot.say(woman);
        //结果
        //hellow,guy
        //hellow,guy
    }
}
