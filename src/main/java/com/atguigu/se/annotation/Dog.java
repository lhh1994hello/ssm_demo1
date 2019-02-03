package com.atguigu.se.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//作者:lhh 创建时间:2019年2月1日 上午8:53:21
/**
 * 测试注解的使用
 * 
 * @author lhh
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Dog {
	String name();

	int age();
}
