package com.atguigu.crud.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//作者:lhh 创建时间:2018年10月22日 上午9:03:04 
public class TestLog {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(TestLog.class);
		String conditon="0";
		switch (conditon) {
		case "1":
			System.out.println("1");
			break;
		case "2":
			System.out.println("2");
			break;
		default: {
			System.out.println("默认");
		}

	}
}
}
