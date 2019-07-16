package com.zw.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2019/3/20 11:30
 */
public class CountDownLatchTest {
    public static void main(String [] args){
        ExecutorService executor= Executors.newFixedThreadPool(5);
        final CountDownLatch countDownLatch=new CountDownLatch(3);


        executor.execute(new Runnable(){
            public void run() {
                try{
                    System.out.println("订机票");
                }finally{
                    countDownLatch.countDown();
                }
            }
        });
        executor.execute(new Runnable(){
            public void run() {
                try{
                    System.out.println("订巴士");
                }finally{
                    countDownLatch.countDown();
                }
            }
        });
        executor.execute(new Runnable(){
            public void run() {
                try{
                    System.out.println("订酒店");
                }finally{
                    countDownLatch.countDown();
                }
            }
        });

        try {
            countDownLatch.await();
            System.out.println("可以出发了");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
