package com.atguigu.crud.test2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

//作者:lhh 创建时间:2019年3月5日 上午9:49:48 
public class PhoneCheck {
	@Test
	public void fun1() {
		String phone = "13123456789";
		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
		if (phone.length() != 11) {
			System.out.println("手机号应为11位数");
		} else {
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(phone);
			boolean isMatch = m.matches();
			if (isMatch) {
				System.out.println("您的手机号" + phone + "是正确格式@——@");
			} else {
				System.out.println("您的手机号" + phone + "是错误格式！！！");
			}
		}
	}
}
