package com.atguigu.se.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lhh
 * @date 2019/4/13 14:56
 * @Description:
 */
public class FixedThreadPoolDemo {
    //因为线程池大小为3，每个任务输出index后sleep 2秒，所以每两秒打印3个数字。
    //定长线程池的大小最好根据系统资源进行设置。如Runtime.getRuntime().availableProcessors()
    public static void main(String[] args) {
        int i1 = Runtime.getRuntime().availableProcessors();
        System.out.println("系统资源:" + i1);

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}
