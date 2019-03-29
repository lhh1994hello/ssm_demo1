package com.atguigu.crud.test2;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

//作者:lhh 创建时间:2019年3月29日 上午9:18:52 
public class JsonObjectDemo {
	@Test
	public void fun1() {
		JSONObject obj = new JSONObject(true);
		obj.put("name", "John");
		obj.put("sex", "male");
		obj.put("age", 22);
		obj.put("is_student", true);
		obj.put("hobbies", new String[] { "hiking", "swimming" });
		// 调用toString()方法可直接将其内容打印出来
		System.out.println(obj.toString());
	}
}
