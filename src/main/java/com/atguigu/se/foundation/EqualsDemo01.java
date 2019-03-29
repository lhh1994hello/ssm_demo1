package com.atguigu.se.foundation;

import org.junit.Test;

import com.atguigu.common.pojo.Car;

//作者:lhh 创建时间:2019年3月29日 上午8:52:31 
/**
 * 
 * @author lhh equals和==测试
 */
public class EqualsDemo01 {
	// equal比较是否是同一个对象，即比较内存地址
	// ==,对于基本数据类型直接比较数据本身，对于引用数据类型，比较内存地址，和equals相同
	@Test
	public void fun1() {
		Car c1 = new Car();
		Car c2 = new Car();

		Car c3 = c1;
		System.out.println(c1 == c2);
		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));
	}
}
