package com.atguigu.leetcode.other;

import java.util.Stack;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

//作者:lhh 创建时间:2019年2月16日 下午10:05:24 
/**
 * 使用堆栈验证括号是否成对出现
 * 
 * @author lhh
 *
 */
public class JudgeBracket {
	@Test
	public void fun1() {
		String str = "{{{";
		boolean judge = judge(str);
		System.out.println(judge);
	}

	// 出现左括号则进栈，出现右括号先判断栈是否为空，为空直接返回false,
	public boolean judge(String bracketStr) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < bracketStr.length(); i++) {
			char temp = bracketStr.charAt(i);
			if (temp == '(' || temp == '{' || temp == '[') {
				stack.push(temp);
			} else if (temp == ')' || temp == '}' || temp == ']'){
				if (stack.isEmpty()) {return false;}
				// 遇到右括号，从堆栈中弹出一个字符，拿出来比较，
				Character pop = stack.pop();
				if (pop == '(' && temp != ')') {
					return false;
				} else if (pop == '[' && temp != ']') {
					return false;
				} else if (pop == '{' && temp != '}') {
					return false;
				}
			}
		}
		//极端情况下全是左括号 ，那么久只入栈，不出栈
		//可以通过判断栈是否为空来验证,不为空就是意味着匹配失败
 		return stack.isEmpty();
	}
}
