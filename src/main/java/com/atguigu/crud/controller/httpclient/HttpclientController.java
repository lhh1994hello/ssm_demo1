package com.atguigu.crud.controller.httpclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crud.util.Msg;

//作者:lhh 创建时间:2019年2月19日 上午9:31:28 
@Controller
@RequestMapping(value = "/httpclient")
public class HttpclientController {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	// 测试无参数的httpclient的get请求
	@RequestMapping(value = "/doGet")
	@ResponseBody
	public Msg doGet() {
		logger.info("测试无参数的httpclient的get请求");
		return Msg.Success();
	}

	@RequestMapping(value = "/doGetWithParam")
	@ResponseBody
	public Msg doGetWithParam(String username, String password) {
		logger.info("有参的httpclient的get请求");
		logger.info("用户名:{},密码:{}", username, password);
		System.out.println("用户名:" + username + ",密码:" + password);
		return Msg.Success();
	}

	@RequestMapping(value = "/doPost")
	@ResponseBody
	public Msg doPost() {
		logger.info("无参的httpclient的post请求");
		return Msg.Success();
	}

	@RequestMapping(value = "/doPostWithParam")
	@ResponseBody
	public Msg doPostWithParam(String username, String password) {
		logger.info("有参的httpclient的post请求");
		logger.info("用户名:{},密码:{}", username, password);
		System.out.println("用户名:" + username + ",密码:" + password);
		return Msg.Success();
	}
}
