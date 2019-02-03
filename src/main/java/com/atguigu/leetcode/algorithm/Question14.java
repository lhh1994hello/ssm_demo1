package com.atguigu.leetcode.algorithm;

import java.util.Arrays;

import org.junit.Test;

//作者:lhh 创建时间:2019年2月3日 上午10:05:06 
/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。 示例 1:
 * 
 * 输入: ["flower","flow","flight"] 输出: "fl" 示例 2:
 * 
 * 输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。
 * 
 * @author lhh
 *
 */
public class Question14 {
	@Test
	public void fun1() {
		String[] strs = { "flower", "flow", "flowight" };
		String[] strs2 = { "caa", "ca", "cacb" };
		String prefix = longestCommonPrefix(strs2);
		System.out.println("最长前缀:" + prefix);
	}

	public static void main(String[] args) {
		Question14 q = new Question14();
		String[] strs3 = {  };
		String prefix = q.longestCommonPrefix(strs3);
		System.out.println("最长前缀:" + prefix);
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs == null||strs.length==0) {
			return "";
		}
		boolean flag = true;
		StringBuffer sbf = new StringBuffer();// 最终输出的结果
		char[][] array = new char[strs.length][];// 二维数组
		int minLength = strs[0].length();// 保存数组中最短字符的长度
		for (int i = 0; i < strs.length; i++) {
			array[i] = strs[i].toCharArray();
			System.out.println("strs[i]" + strs[i].length());
			if (i > 0 && strs[i].length() < minLength) {
				minLength = strs[i].length();
			}
		}
		if (minLength == 0) {
			return "";
		}
		// 外层控制列,内层控制行
		for (int i = 0; i < minLength; i++) {
			for (int j = 1; j < strs.length; j++) {
				if (array[j - 1][i] != array[j][i]) {
					flag = false;
					break;
				}
			}
			if (!flag) {
				break;
			}
			sbf.append(array[0][i]);
		}
		return sbf.toString();
	}
}

/**
 * [f, l, o, w, e, r], [f, l, o, w], [f, l, i, g, h, t]
 */
