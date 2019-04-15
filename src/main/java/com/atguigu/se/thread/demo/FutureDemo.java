package com.atguigu.se.thread.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @Author: lhh
 * @Date: 2019/4/15 22:49
 * @Version 1.0
 */
public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //创建一个Callable，3秒后返回String类型
        Callable myCallable = new Callable() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                System.out.println("calld方法执行了");
                return "call方法返回值";
            }
        };
        System.out.println("提交任务之前 " + getStringDate());
        Future future = executor.submit(myCallable);
        System.out.println("提交任务之后，获取结果之前 " + getStringDate());
        System.out.println("获取返回值: " + future.get());//get方法是阻塞的，等到线程执行完才接着执行
        System.out.println("获取到结果之后 " + getStringDate());

    }

    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }


}
