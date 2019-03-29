package com.atguigu.crud.test2;

import java.math.BigDecimal;

//作者:lhh 创建时间:2019年3月26日 上午11:53:01 
public class TestInteger {
	public static void main(String[] args) {
		String str = "254468849979Z";
		String s = new BigDecimal(str).toPlainString();
		System.out.println(s);
	}
}
