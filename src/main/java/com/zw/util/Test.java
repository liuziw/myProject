package com.zw.util;

import com.zw.domain.Role;
import com.zw.domain.Shop;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2019/3/23 17:09
 */
public class Test {

    public static void main(String [] args){
        String s1 = "wangwu";
        String s2 = "wangwu";
        String s3 = "wang"+"wu";
        String s4 = "wang";
        String s5 = "wu";
        String s6 = s4+s5;
        String s7 = "wang".concat("wu");
        String s8 = s4.concat(s5);
        String s9 = new StringBuilder("wangwu").toString();
        String s10 = new StringBuilder("wang").append("wu").toString();
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1); // true intern()方法会把首次遇到的字符串示例复制到永久待中，返回的也是永久带中这个字符串实例的引用
        String str2 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str2); // false "计算机软件"这个字符串前面已经出现过了，不符合首次出现的原则，常量池中已经有了他的引用，intern()将不会
                                                    //复制新创建的这个实例，而是返回之前的示例，因此intern()返回的实例与新创建的new StringBuilder不是同一个实例
//        s3 = s1;
//        s1 = "lisi";

        System.out.println(s2 == s6); // false
        System.out.println(s2 == s6.intern()); //true s4+s5是引用相加放在堆里 intern()如果常量池中已经存在该字符串，则直接返回常量池中该对象的引用，比从堆中拿快，提高效率
        System.out.println(s2 == s7);// false
        System.out.println(s3 == s7);// false
        System.out.println(s3 == s6); //false
        System.out.println(s6 == s8);// false
        System.out.println(s1==s2);// true
        System.out.println(s1==s3);// true
        System.out.println(s2==s3);// true
        System.out.println(s1 == s9); // false
        System.out.println(s1 == s10); // false


    }
}
