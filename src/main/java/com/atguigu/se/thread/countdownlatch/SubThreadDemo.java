package com.atguigu.se.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author lhh
 * @date 2019/4/15 12:46
 * @Description: 测试线程同步，
 */
public class SubThreadDemo implements Runnable {
    private CountDownLatch threadsSignal;
    //线程执行成功是true,出现异常是false
    private boolean status = false;

    @Override
    public void run() {
        System.out.println("开始执行...," + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        status = true;
        System.out.println("执行完毕...," + Thread.currentThread().getName());

        threadsSignal.countDown();//计数器减一
        long count = threadsSignal.getCount();
        System.out.println("***计数器数量：" + count);
    }

    public CountDownLatch getThreadsSignal() {
        return threadsSignal;
    }

    public void setThreadsSignal(CountDownLatch threadsSignal) {
        this.threadsSignal = threadsSignal;
    }

    public boolean isStatus() {
        return status;
    }
}
