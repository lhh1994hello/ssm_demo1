package com.atguigu.crud.test;

import java.util.Calendar;

//作者:lhh 创建时间:2018年12月26日 上午8:55:29 
public class DHCode {
	public static void main(String[] args) {
		int m;
		int d;
		Calendar cal = Calendar.getInstance();
		m = cal.get(Calendar.MONTH) + 1;// 月
		d = cal.get(Calendar.DATE);// 天
		int totalNum = d * d * d + m * m;
		StringBuffer sb = new StringBuffer().append(totalNum);
		String substring = sb.substring(3);
		String termaial = substring + m + d;
		System.out.println("验证码:" + termaial);
	}

}
