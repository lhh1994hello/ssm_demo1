package com.atguigu.se.thread.countdownlatch;

import com.atguigu.crud.util.SubThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author lhh
 * @date 2019/4/15 12:50
 * @Description:
 */
public class MainThreadDemo {
    public List<SubThreadDemo> subThreadList = new ArrayList<SubThreadDemo>();

    public SubThreadDemo createSubThread() {
        SubThreadDemo subThread = new SubThreadDemo();
        subThreadList.add(subThread);
        return subThread;
    }

    //返false代表有线程执行异常
    public boolean start() throws InterruptedException {
        CountDownLatch threadSignal = new CountDownLatch(subThreadList.size());
        for (SubThreadDemo subThreadDemo : subThreadList) {
            subThreadDemo.setThreadsSignal(threadSignal);
            Thread thread = new Thread(subThreadDemo);
            thread.start();
        }
        threadSignal.await();//等待着

        System.out.println("所有子线程执行完毕...");
        for (SubThreadDemo subThreadDemo : subThreadList) {
            if (!subThreadDemo.isStatus()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        MainThreadDemo main = new MainThreadDemo();
        main.createSubThread();
        main.createSubThread();
        main.createSubThread();
        main.createSubThread();
        boolean start = main.start();

    }
}
