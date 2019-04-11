package com.atguigu.crud.test.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//作者:lhh 创建时间:2019年2月18日 下午5:44:05 
public class TimeTest {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date startTime = getStartTime();
		Date endTime = getnowEndTime();
		System.out.println(startTime);
		System.out.println(endTime);
		System.out.println("=============");
		String startTimeStr = sdf.format(startTime);
		String endTimeStr = sdf.format(endTime);
		System.out.println(startTimeStr);
		System.out.println(endTimeStr);
	}

	public static Date getStartTime() {
		Calendar todayStart = Calendar.getInstance();
		todayStart.set(Calendar.HOUR_OF_DAY, 0);
		todayStart.set(Calendar.MINUTE, 0);
		todayStart.set(Calendar.SECOND, 0);
		todayStart.set(Calendar.MILLISECOND, 0);
		return todayStart.getTime();
	}

	public static Date getnowEndTime() {
		 Calendar todayEnd = Calendar.getInstance();
	     todayEnd.set(Calendar.HOUR_OF_DAY, 23);
	     todayEnd.set(Calendar.MINUTE, 59);
	     todayEnd.set(Calendar.SECOND, 59);
	     return todayEnd.getTime();
	}

}
