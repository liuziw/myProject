package com.zw.ZookeeperLock;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2019/3/19 9:52
 */
public class TestLock {
    static int n = 500;

    public static void secskill() {
        System.out.println(--n);
    }

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            public void run() {
                DistributedLock lock = null;
                try {
                    lock = new DistributedLock("10.225.74.28:2181","test1");
                    lock.lock();
                    secskill();
                    if (lock != null) {
                        System.out.println(Thread.currentThread().getName() + "正在运行");
                    }
                } finally {
                    /*if (lock != null) {
                        lock.unlock();
                    }*/
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
    }
}
