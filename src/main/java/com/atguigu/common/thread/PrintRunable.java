package com.atguigu.common.thread;

/**
 * @Author: lhh
 * @Date: 2019/4/16 21:53
 * @Version 1.0
 */
public class PrintRunable implements Runnable {
    private String name;

    public PrintRunable(String name) {
        this.name = name;
    }

    public PrintRunable() {
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "," + this.name + " is running.");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadName + "," + this.name + " is running again.");
    }
}
