package com.atguigu.leetcode.algorithm;

import org.junit.Test;

//作者:lhh 创建时间:2019年1月22日 下午12:56:25 
/**
 * 7.整数反转,给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * @author lhh
 *
 */
public class Question7 {
	@Test
	public void fun1() {
		long param = -12345;
		long reverse = reverse(param);
		System.out.println("逆序:" + reverse);
	}

	public long reverse(long x) {
		if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
			return 0;
		}
		long i = 0;
		long t = x;
		while (t != 0) {
			i = 10 * i + t % 10;
			t = t / 10;
		}
		return i;
	}

	public long reverse2(long x) {
		long t = x;
		long i = 0;
		while (t != 0) {
			i = i * 10 + t % 10;
			t = t / 10;
		}
		return i;
	}

}
