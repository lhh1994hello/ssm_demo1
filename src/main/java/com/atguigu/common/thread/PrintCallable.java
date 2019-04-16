package com.atguigu.common.thread;

import java.util.concurrent.Callable;

/**
 * @Author: lhh
 * @Date: 2019/4/16 21:56
 * @Version 1.0
 */
public class PrintCallable implements Callable<Boolean> {
    private String name;

    public PrintCallable(String name) {
        this.name = name;
    }

    public PrintCallable() {
    }

    @Override
    public Boolean call() throws Exception {
        String threadName = Thread.currentThread().getName();
        System.out.println("线程名:" + threadName + "," + this.name + " is running.");
        try {
            Thread.sleep(3000);
            System.out.println("线程名:" + threadName + "," + this.name + " is running again.");
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
}
