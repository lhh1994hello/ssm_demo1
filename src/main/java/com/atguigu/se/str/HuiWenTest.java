package com.atguigu.se.str;

import org.junit.Test;

//作者:lhh 创建时间:2019年1月30日 下午9:30:33 
/**
 * 是否为回文数，回文是对称的，如aba,abccba,abcdcba。 abccda不是回文数
 * 
 * @author lhh
 *
 */
public class HuiWenTest {

	@Test
	public void fun1() {
		String str = "ab";
		boolean huiWenStr = isHuiWenStr(str);
		System.out.println(huiWenStr);

	}

	public boolean isHuiWenStr(String str) {
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length / 2; i++) {
			if (charArray[i] != charArray[charArray.length - i - 1]) {
				return false;
			}
		}
		return true;
	}
}
