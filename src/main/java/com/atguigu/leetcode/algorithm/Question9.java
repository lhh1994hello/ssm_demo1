package com.atguigu.leetcode.algorithm;

import org.junit.Test;

//作者:lhh 创建时间:2019年2月3日 上午9:47:39 
/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 
 * @author lhh
 * 
 *         示例 2: 输入: -121 输出: false 解释: 从左向右读, 为 -121 。 从右向左读, 为 121-
 *         。因此它不是一个回文数。 示例 3:
 * 
 *         输入: 10 输出: false 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Question9 {
	@Test
	public void fun1() {
		int x = 12321;
		boolean palindrome = isPalindrome(x);
		System.out.println("是否为回文数:" + palindrome);
	}

	public boolean isPalindrome(int x) {
		String str = String.valueOf(x);
		if (x < 0) {
			return false;
		}

		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}
}
