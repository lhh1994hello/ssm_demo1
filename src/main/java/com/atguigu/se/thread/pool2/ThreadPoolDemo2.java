package com.atguigu.se.thread.pool2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lhh
 * @date 2019/4/13 16:33
 * @Description:
 */
public class ThreadPoolDemo2 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));

        for (int i = 0; i < 15; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中待执行的任务数：" + executor.getQueue().size() + "，已执行的任务数：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }

    static class MyTask implements Runnable {
        private int taskNum;

        public MyTask(int num) {
            this.taskNum = num;
        }

        @Override
        public void run() {
            System.out.println("正在执行task " + taskNum);
            try {
                Thread.currentThread().sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task " + taskNum + "执行完毕");
        }
    }
}
