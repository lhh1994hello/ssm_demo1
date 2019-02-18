//2019年2月18日 下午10:47:34 用户：lhh
package com.atguigu.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 * 
 * @author lhh
 *
 */
public class Question17 {
	String[] dict = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	@Test
	public void fun1() {
		List<String> combinations = letterCombinations("23");
		System.out.println(combinations);
	}

	public List<String> letterCombinations(String digits) {

		List<String> res = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return res;
		}
		backTracking(new StringBuilder(), digits, 0, res);
		return res;

	}

	private void backTracking(StringBuilder temp, String digits, int index, List<String> res) {
		if (temp.length() == digits.length()) {
			res.add(temp.toString());
			return;
		}
		for (int i = 0; i < dict[digits.charAt(index) - '0'].length(); i++) {
			temp.append(dict[digits.charAt(index) - '0'].charAt(i));
			backTracking(temp, digits, index + 1, res);
			if (temp.length() > 0) {
				temp.deleteCharAt(temp.length() - 1);
			}
		}
	}

}
