package com.zw.util;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * 基于jdk1.8实现任务异步处理
 *
 * @author Administrator
 *
 */
public class JavaPromise {
    public static void main(String[] args) throws Throwable, ExecutionException {
        // 两个线程的线程池
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //jdk1.8之前的实现方式
        /*CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("task started!");
                try {
                    //模拟耗时操作
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "task finished!";
            }
        }, executor);*/
        //以上可用lambda简写为
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->longTask(2000L),executor);


        //采用lambada的实现方式
        future.thenAccept(e -> cal(e));
        //回调使用上面的结果
        CompletableFuture<String> future2 = future.thenApply(e -> returnCal(e));
        System.out.println(future2);

        System.out.println("main thread is running");
    }

    public static void cal(String e){
        System.out.println(e + " cal");
    }

    public static String returnCal(String e){
        return e + " ok";
    }

    public static String longTask(Long time){
        System.out.println("task started!");
        try {
            //模拟耗时操作
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "task finished!";
    }
}