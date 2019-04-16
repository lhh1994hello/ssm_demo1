package com.atguigu.crud.controller.test;

import com.atguigu.common.thread.PrintCallable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crud.service.ThreadService;
import com.atguigu.crud.util.Msg;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

//作者:lhh 创建时间:2018年11月12日 下午12:23:47 
@Controller
@RequestMapping(value = "/thread")
public class ThreadController {
    @Autowired
    private ThreadService threadService;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @ResponseBody
    @RequestMapping(value = "/threadFun1")
    public Msg threadFun1() {
        System.out.println("测试线程同步.......");
        try {
            threadService.threadFun1();
        } catch (Exception e) {
            System.out.println("操作失败...........");
        }
        return Msg.Success();
    }

    /**
     * 使用线程池
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/useThreadPool")
    public Msg useThreadPool() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("主线程开始执行...:" + sdf.format(new Date()));
        Future<Boolean> future1 = threadPoolTaskExecutor.submit(new PrintCallable("线程1"));
        Future<Boolean> future2 = threadPoolTaskExecutor.submit(new PrintCallable("线程2"));
        Future<Boolean> future3 = threadPoolTaskExecutor.submit(new PrintCallable("线程3"));
        Future<Boolean> future4 = threadPoolTaskExecutor.submit(new PrintCallable("线程4"));
        Future<Boolean> future5 = threadPoolTaskExecutor.submit(new PrintCallable("线程5"));
        Future<Boolean> future6 = threadPoolTaskExecutor.submit(new PrintCallable("线程6"));

        try {
            Boolean flag1 = future1.get();
            Boolean flag2 = future2.get();
            Boolean flag3 = future3.get();
            Boolean flag4 = future4.get();
            Boolean flag5 = future5.get();
            Boolean flag6 = future6.get();
            if (flag1 && flag2 && flag3 && flag4 && flag5 && flag6) {
                System.out.println("继续执行主线程...:" + sdf.format(new Date()));
            }
            System.out.println("主线程执行结束...:" + sdf.format(new Date()));
            return Msg.Success().add("msg", "执行成功啦啦啦");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        return Msg.fail().add("msg", "执行失败！");
    }

}
