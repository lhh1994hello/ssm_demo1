package com.atguigu.se.thread.pool;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lhh
 * @date 2019/4/13 15:00
 * @Description: https://cuisuqiang.iteye.com/blog/2019372
 */
public class CachedThreadPoolDemo {
    public static void main(String[] args) {
        final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(index);
                }
            });
        }
    }
}
