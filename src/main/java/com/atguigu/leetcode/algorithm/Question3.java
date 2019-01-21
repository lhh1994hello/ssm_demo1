package com.atguigu.leetcode.algorithm;

import org.junit.Test;

//作者:lhh 创建时间:2019年1月21日 下午12:37:46 
/**
 * 
 * @author lhh 无重复字符的最长子串 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Question3 {
	@Test
	public void fun1() {
		String s = "asdfawea";
		int maxLength = lengthOfLongestSubstring(s);
		String maxSubstring = maxSubstring(s);
		System.out.println(maxLength);
		System.out.println(maxSubstring);

	}

	// 最长子串,滑动窗口
	public int lengthOfLongestSubstring(String s) {
		// 索引值是ASCII的值，用来记录对应ASCII出现的频率
		int[] freq = new int[256];
		int left = 0, right = -1;// 滑动窗口为s
		int res = 0;// 用来记录子串的长度。
		while (right + 1 < s.length()) {
			//System.out.println("字符:" + s.charAt(right + 1));
			if (freq[s.charAt(right + 1)] == 0) {
				right++;
				freq[s.charAt(right)]++;
			} else {
				freq[s.charAt(left)]--;
				left++;
			}
			int temp = right - left + 1;
			res = res >= temp ? res : temp;

		}
		return res;
	}

	public String maxSubstring(String s) {
		if (s == null) {
			throw new RuntimeException("字符串不能为空!");
		}
		// 用来记录字符串是否出现过，单个字符对应编码的int值作为索引
		int[] freq = new int[256];
		int left = 0, right = -1;
		int res = 0;// 子串的长度
		while (right + 1 < s.length()) {
			if (freq[s.charAt(right + 1)] == 0) {
				right++;
				freq[s.charAt(right)]++;
			} else {
				freq[s.charAt(left)]--;
				left++;
			}
			int temp = right - left + 1;
			res = res >= temp ? res : temp;//记录最大值
		}
		System.out.println("长度："+res);
		System.out.println("left:"+left);
		System.out.println("right:"+right);
		return s.substring(left, right + 1);
	}

	/*
	 * public int lengthOfLongestSubstring(String s) {
	 * //索引值是ASCII的值，用来记录对应ASCII出现的频率 int[] freq = new int[256]; int left = 0,
	 * right = -1;//滑动窗口为s int res = 0;//用来记录子串的长度。 while (left < s.length()) {
	 * if (right + 1 < s.length() && freq[s.charAt(right + 1)] == 0) { right++;
	 * freq[s.charAt(right)]++; } else { freq[s.charAt(left)]--; left++; } int
	 * temp = right - left + 1; res = res >= temp ? res : temp; } return res; }
	 */

}
