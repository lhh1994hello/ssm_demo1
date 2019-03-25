package com.atguigu.demo.log;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//作者:lhh 创建时间:2019年3月22日 下午8:10:24 
public class LogDemo01 {
	private static final Logger logger = LoggerFactory.getLogger(LogDemo01.class);

	public static void main(String[] args) {
		LogDemo01 logdemo = new LogDemo01();
		logdemo.fun1();
	}

	public void fun1() {
		logger.info("日志:{}", new Date());
	}
}
