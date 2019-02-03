package com.atguigu.leetcode.algorithm;

import org.junit.Test;

//作者:lhh 创建时间:2019年2月3日 上午11:48:07 
/**
 * 
 * @author lhh 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 
 *         不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 
 *         示例 1:
 * 
 *         给定数组 nums = [1,1,2],
 * 
 *         函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 
 *         你不需要考虑数组中超出新长度后面的元素。 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 */
public class Question26 {
	@Test
	public void fun1() {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int duplicates = removeDuplicates(nums);
		System.out.println(duplicates);

	}

	/**
	 * 可以用两个指针front和back来实现：
	 * 
	 * 如果back与front正好重复了，拉动front，直到back和front不重复为止；
	 * 
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {
		int back = 0;
		for (int front = 1; front < nums.length; front++) {
			if (nums[back] != nums[front]) {
				back++;
				nums[back] = nums[front];
			}
		}
		return back + 1;
	}

}
