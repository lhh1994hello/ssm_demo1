package com.atguigu.se.thread.demo;

import com.atguigu.se.thread.bean.ChujuCallable;
import com.atguigu.se.thread.bean.SuCaiCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: lhh
 * @Date: 2019/4/15 23:44
 * @Version 1.0
 * Future类使用，Callable任务返回Future对象
 */
public class DeliciousFoodDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        ChujuCallable chujuCallable = new ChujuCallable();
        SuCaiCallable suCaiCallable = new SuCaiCallable();

        Future<Boolean> chujuFuture = service.submit(chujuCallable);
        Future<Boolean> suCaiFuture = service.submit(suCaiCallable);

        try {
            Boolean chujuFlag = chujuFuture.get();
            Boolean suCaiFlag = suCaiFuture.get();
            if (chujuFlag && suCaiFlag) {
                System.out.println("准备好了，开始做饭!");
            } else {
                System.out.println("还没准备好呢!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();
    }
}
