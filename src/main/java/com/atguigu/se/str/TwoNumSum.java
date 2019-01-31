package com.atguigu.se.str;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

//作者:lhh 创建时间:2019年1月31日 上午9:20:42 
/**
 * 给出一个整数数组，和一个数t，在数组中找出两个数使这两个数等于t
 * 
 * @author lhh
 *
 */
public class TwoNumSum {
	@Test
	public void fun1() {
		int arrayDemo[] = { 1, 2, 4, 7, 9, 192, 100 };
		int[] twoNumSumTest1 = twoNumSumTest1(arrayDemo, 5);
		System.out.println(Arrays.toString(twoNumSumTest1));
	}

	public int[] twoNumSumTest1(int[] array, int t) {
		int[] result = null;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			map.put(array[i], array[i]);
		}
		for (int i = 0; i < array.length; i++) {
			Integer temp = t - array[i];
			if (map.containsKey(temp)) {
				result = new int[2];
				result[0] = array[i];
				result[1] = temp;
				//break;
			}

		}
		return result;
	}
}
