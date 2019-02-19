package com.atguigu.crud.test1;

import java.math.BigDecimal;

import org.junit.Test;

//作者:lhh 创建时间:2018年12月7日 下午2:05:42 
public class ExcelTest1 {

	@Test
	public void fun1() {
		String input = "1.44335632343E21";
		BigDecimal one = new BigDecimal(input);
		String regx = "^((-?\\d+.?\\d*)[Ee]{1}(-?\\d+))$";// 科学计数法正则表达式
		boolean matches = input.matches(regx);
		System.out.println(matches);
		// BigDecimal one = new BigDecimal(1.44335632343E21);
		System.out.println(one.toPlainString());
	}

}
