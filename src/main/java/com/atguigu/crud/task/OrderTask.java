package com.atguigu.crud.task;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//作者:lhh 创建时间:2019年1月11日 上午11:50:29 
@Component
public class OrderTask {
    @Scheduled(cron = "*/5 * * * * ?")
	public void begin(){
		System.out.println("A:"+new Date());
	}
}
