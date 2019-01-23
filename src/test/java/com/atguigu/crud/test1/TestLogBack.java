package com.atguigu.crud.test1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//作者:lhh 创建时间:2019年1月23日 上午11:01:40 
public class TestLogBack {
	Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		System.out.println("测试logback日志...");
		TestLogBack testLogBack = new TestLogBack();
		testLogBack.showLog();
	}

	private void showLog() {
		logger.info("测试logback日志...");
	}

}
