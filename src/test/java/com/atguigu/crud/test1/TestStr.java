package com.atguigu.crud.test1;

import java.util.Arrays;

import org.junit.Test;

//作者:lhh 创建时间:2019年1月24日 上午9:02:54 
public class TestStr {
	@Test
	public void fun1() {
		StringBuffer sbf = new StringBuffer();
		String str = "abc-1de/fg";
		String regex1 = "[^a-zA-Z]";// 按非字符分隔
		String regex2 = "[a-zA-Z]";// 按字符分隔
		String[] split1 = str.split(regex1);

		String[] split2 = str.split(regex2);
		String arrayStr1 = Arrays.toString(split1);
		String arrayStr2 = Arrays.toString(split2);
		System.out.println("字符:" + arrayStr1);
		System.out.println("非字符:" + arrayStr2);

		String reverseString = reverseSubStr(str);
		System.out.println("翻转后:" + reverseString);
		int temp = 0;
		for (int i = 0; i < split1.length && temp < split2.length; i++) {
			if ("".equals(split1[i])) {
				continue;
			}
			sbf.append(reverseSubStr(split1[i]));
			
		}

	}

	// 子字符翻转
	private String reverseSubStr(String str) {
		if ((str == null) || str.length() < 2) {
			return str;
		}
		return reverseSubStr(str.substring(1)) + str.charAt(0);
	}
}
