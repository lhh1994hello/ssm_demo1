package com.atguigu.crud.test2;

import java.math.BigDecimal;

//作者:lhh 创建时间:2019年3月11日 上午10:44:55 
public class MoneyRegexTest {
	public static void main(String[] args) {
		String moneyRegex = "(^[1-9]([0-9]+)?(\\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\\.[0-9]([0-9])?$)";
		String moneyAccount = "1.22";
		if (moneyAccount.matches(moneyRegex)) {
			System.out.println("匹配");
		} else {
			System.out.println("不匹配");
		}
		BigDecimal bigDecimal = new BigDecimal(moneyAccount);
		System.out.println("结果:" + bigDecimal);
	}
}
