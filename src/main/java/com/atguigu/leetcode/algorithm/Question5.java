package com.atguigu.leetcode.algorithm;

import java.util.Arrays;

import org.junit.Test;

//作者:lhh 创建时间:2019年2月2日 下午5:25:32 
/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * @author lhh
 *
 */
@SuppressWarnings("all")
public class Question5 {
	@Test
	public void fun1() {
		String s = "";
		longestPalindrome(s);
	}

	// 最长回文子串
	public String longestPalindrome(String s) {
		char[] freq = new char[256];
		System.out.println(Arrays.toString(freq));
		int left = 0;
		int right = -1;
		
		return "";
	}
}
