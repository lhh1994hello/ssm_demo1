package com.atguigu.crud.bean;

import java.util.HashMap;
import java.util.Map;

public class Msg {
	// 状态码 100-成功，200-失败
	private int code;
	// 提升信息
	private String message;
	// 用户要返回给浏览器的数据
	Map<String, Object> extend = new HashMap<String, Object>();

	// 成功方法
	public static Msg Success() {
		Msg msg = new Msg();
		msg.setCode(100);
		msg.setMessage("处理成功");
		return msg;
	}

	public Msg add(String key, Object value) {
		this.getExtend().put(key, value);
		return this;
	}

	// 失败
	public static Msg fail() {
		Msg msg = new Msg();
		msg.setCode(200);
		msg.setMessage("处理失败.");
		return msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}

	@Override
	public String toString() {
		System.out.println();
		return "Msg [code=" + code + ", message=" + message + ", extend=" + extend + "]";
	}

}
