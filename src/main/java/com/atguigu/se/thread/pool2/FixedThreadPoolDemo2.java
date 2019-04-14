package com.atguigu.se.thread.pool2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: lhh
 * @Date: 2019/4/14 9:40
 * @Version 1.0
 */
public class FixedThreadPoolDemo2 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i=0;i<6;i++){
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.MICROSECONDS.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程名:"+Thread.currentThread().getName());
                }
            });
        }
        System.out.println(service);
        service.shutdown();
        System.out.println(service);
        System.out.println("terminated:"+service.isTerminated());
        System.out.println("shutdown:"+service.isShutdown());
    }
}
