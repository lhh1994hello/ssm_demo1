package com.atguigu.leetcode.other;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

//作者:lhh 创建时间:2019年2月16日 下午9:29:23 
/**
 * 让一个数组中奇数在前偶数在后
 * 
 * @author lhh
 *
 */
public class SwapOddAndEvenNumber {

	@Test
	public void fun1() {
		Random random = new Random();
		int[] array = new int[random.nextInt(10) + 11];// 定义一个数组，长度在11到20之间
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(200);
		}
		System.out.println("初始集:" + Arrays.toString(array));
		arrayTest(array);
	}

	public int[] arrayTest(int[] array) {
		int left = 0;
		int right = array.length - 1;
		// left从左边往右找到偶数时停止，right从右往左找到奇数时停止
		while (left < right) {
			// 找偶数，不是偶数就往右走
			while (left < right && array[left] % 2 != 0) {
				left++;
			}
			// 找奇数，不是奇数就往左走
			while (left < right && array[right] % 2 == 0) {
				right--;
			}
			// 如1,3,5时，不需要交换，如果不判断，也会进行交换的
			if (left < right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
			}
		}
		System.out.println("结果集:" + Arrays.toString(array));
		return array;
	}

}
