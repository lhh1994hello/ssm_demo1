package com.atguigu.demo.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.atguigu.common.pojo.Dog;

//作者:lhh 创建时间:2019年3月19日 下午1:12:15 
public class IOCDemo1 {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:config/applicationTest.xml");
		Dog dog = (Dog) context.getBean("dog");
		System.out.println(dog);
	}
}
