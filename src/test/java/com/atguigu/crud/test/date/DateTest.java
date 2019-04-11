package com.atguigu.crud.test.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//作者:lhh 创建时间:2019年3月15日 下午4:26:00 
public class DateTest {
	public static void main(String[] args) throws ParseException {
//		String s = "Mon Aug 03 00:00:00 CST 2207";
//		  DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
//
//	      Date date = df.parse(s);// 那天是周一
//	      // 创建所需的格式
//	      df = new SimpleDateFormat("yyyy-MM-dd");
//	      String str = df.format(date);// 获得格式化后的日期字符串
//	      System.err.println(str);// 打印最终结果
		String s = "Mon Aug 03 00:00:00 CST 2207";
		try {
			DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
            Date date = df.parse(s);// 那天是周一
            df = new SimpleDateFormat("yyyy-MM-dd");
            String str = df.format(date);// 获得格式化后的日期字符串
            System.out.println(str);
        } catch (ParseException e) {
             e.printStackTrace();
        }
	}
}
