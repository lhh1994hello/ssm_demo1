package com.atguigu.imooc;

import org.junit.Test;

//作者:lhh 创建时间:2019年2月17日 下午9:22:23 
/**
 * 二分查找
 * 
 * @author lhh
 *
 */
public class BinarySearch {
	@Test
	public void fun1() {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		int test = binarySearchTest(array, 21);
		System.out.println("索引:" + test);
	}

	// 二分查找,返回目标值的索引下标
	public int binarySearchTest(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;// 在[left....right]的范围里查找target
		while (left <= right) {// 当left==right时，区间[left...right]依然是有效的
			int mid = (right + left) / 2;
			if (array[mid] == target) {
				return mid;
			}
			if (target > array[mid]) {
				left = mid + 1;// target在[mid+1...right]中
			} else {// target < array[mid]
				right = mid - 1;// target在[left...mid-1]中
			}
		}
		return -1;
	}


}
