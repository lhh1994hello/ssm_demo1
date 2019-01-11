package com.atguigu.crud.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

//作者:lhh 创建时间:2018年11月29日 上午9:23:05 
public class TestDate {
	@Test
	public void fun1() throws ParseException{
		Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(DateFormat.getDateTimeInstance().format(new Date()));
		System.out.println(parse);

	}
}
