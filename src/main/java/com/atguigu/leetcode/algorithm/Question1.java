package com.atguigu.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

//作者:lhh 创建时间:2019年2月3日 上午9:17:05 
/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
 * 
 * @author lhh
 *
 */
@SuppressWarnings("all")
public class Question1 {
	@Test
	public void fun1() {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] twoSum = twoSum(nums, target);
		System.out.println("下标:" + Arrays.toString(twoSum));
	}

	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// 使用哈希减少一层循环，用数组的值做键，数组下标做值
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int temp = target - nums[i];
			// 如果有期望的值,且该值不等于自身
			if (map.containsKey(temp) && map.get(temp) != i) {
				return new int[] { i, map.get(temp) };
			}
		}
		return null;
	}
}
