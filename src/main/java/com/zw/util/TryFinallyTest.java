package com.zw.util;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2019/4/23 18:19
 */
public class TryFinallyTest {

    public static int orderTest(){
        try {
            //执行顺序
            int a = 0; //1
            return a; //3
        }finally {
            System.out.println("aa"); //2
        }
    }

    public static int orderTest2(){
        int x;
        try {
            x=1; //1
            x = x/0;
            return x;
        }catch (Exception e){
            x=2; //2
            return x; //3
        }finally {
            x=3; //4
            return x; //5
        }
        //此方法返回值为3
    }

    public static void orderTest3(){
        int x;
        try {
            x=1;
            x = x/0;
        }catch (Exception e){
            x=2;
        }finally {
            x=3;
        }
        System.out.println(x); // 3
    }

    public static void main(String [] args) throws Exception{

        System.out.println(orderTest2());
        System.out.println("-------------");
        orderTest3();

    }
}
