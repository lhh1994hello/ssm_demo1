package com.atguigu.se.enums;

//作者:lhh 创建时间:2019年3月1日 上午10:27:40 
public enum OrderEnumTest {

	WAIT(0, "等待支付"), SUCCESS(1, "支付成功");
	private Integer code;
	private String message;

	private OrderEnumTest(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
