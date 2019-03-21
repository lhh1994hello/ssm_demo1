package com.atguigu.crud.controller.test;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crud.util.Msg;

//作者:lhh 创建时间:2019年3月7日 下午3:01:36 
@Controller
@RequestMapping(value = "/testRequestHead")
public class TestRequestHeadController {
	@RequestMapping(value = "/head")
	@ResponseBody
	public Msg head(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AAAAA");
		Enumeration<String> headerNames = request.getHeaderNames();
		String authType = request.getAuthType();
		String contentType = request.getHeader("Content-Type");

		System.out.println("authType:" + authType);
		System.out.println("contentType:" + contentType);
		System.out.println(headerNames);
		return Msg.Success();
	}
}
