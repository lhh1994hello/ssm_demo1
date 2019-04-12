package com.atguigu.crud.task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//作者:lhh 创建时间:2019年1月11日 上午11:50:29 
@Component
public class OrderTask {

    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //@Scheduled(cron = "* 1 * * * ?")
    //@Scheduled(cron = "*/10 * * * * ?")
    @Scheduled(cron = "0 0/30 * * * ?")
    public void begin() {
        String nowDateStr = sdf.format(new Date());
        System.out.println(nowDateStr + "***cron-A:" + "每隔60分钟执行一次");
    }


    //每10秒执行一次，程序睡眠15秒再执行，下次定时任务来的时候，该方法还在执行
    //那么下次定时任务就不再执行，等到下一个时刻到来后再执行
    //@Scheduled(cron = "*/30 * * * * ?")
    @Scheduled(cron = "0 0/16 * * * ?")
    public void taskCron() throws InterruptedException {
        String nowDateStr = sdf.format(new Date());
        Thread.sleep(17 * 1000 * 60);
        System.out.println(nowDateStr + "######cron-B:" + "每隔16分钟执行一次,睡眠");
    }

    //以一个固定延迟时间5秒钟调用一次执行
    //这个周期是以上一个调用任务的##完成时间##为基准，在上一个任务完成之后，5s后再次执行
    @Scheduled(fixedDelay = 20 * 1000 * 60)
    public void taskFixedDelay() {
        String nowDateStr = sdf.format(new Date());
        System.out.println(nowDateStr + "--fixedDelay:" + "方法结束后20分钟执行再执行");
    }

}
