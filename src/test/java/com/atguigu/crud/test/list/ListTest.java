package com.atguigu.crud.test.list;

import java.util.Arrays;
import java.util.List;

//作者:lhh 创建时间:2018年12月19日 上午9:14:49 
@SuppressWarnings("all")
public class ListTest {
	// @Test
	public void fun1() {
		String[] arrayA = new String[] { "A", "B", "C", "D", "E", "F" };
		String[] arrayB = new String[] { "B", "D", "F", "G", "H", "K" };
		List<String> listA = Arrays.asList(arrayA);
		List<String> listB = Arrays.asList(arrayB);

	}

}
