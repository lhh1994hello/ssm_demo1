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
		int maxSubStrLen2 = maxSubStrLen2(s);
		System.out.println(maxLength);
		System.out.println(maxSubStrLen2);
	}

	// 最长子串,滑动窗口
	public int lengthOfLongestSubstring(String s) {
		// 索引值是ASCII的值，用来记录对应ASCII出现的频率
		int[] freq = new int[256];
		int left = 0, right = -1;// 滑动窗口为s
		int res = 0;// 用来记录子串的长度。
		while (right + 1 < s.length()) {
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

	// 求最长子串的长度，同时求出了最长的子串:
	public int maxSubStrLen2(String s) {
		int res = 0;//用来保存最长子串的长度
		int left = 0;
		int right = -1;
		String subStr = "";//用来保存最长子串
		int[] freq = new int[256];
		while (right + 1 < s.length()) {
			if (freq[s.charAt(right + 1)] == 0) {
				right++;
				freq[s.charAt(right)]++;
			} else {
				freq[s.charAt(left)]--;
				left++;
			}
			int temp = right - left + 1;
			String tempStr = s.substring(left, right + 1);
			subStr = subStr.length() >= tempStr.length() ? subStr : tempStr;
			res = res >= temp ? res : temp;// 求最大值
		}
		System.out.println("最长子串:" + subStr);
		return res;
	}
}
