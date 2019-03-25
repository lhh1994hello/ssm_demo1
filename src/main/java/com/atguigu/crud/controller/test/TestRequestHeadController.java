package com.atguigu.crud.controller.test;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crud.util.Msg;

//作者:lhh 创建时间:2019年3月7日 下午3:01:36 
@Controller
@RequestMapping(value = "/testRequestHead")
public class TestRequestHeadController {
	private static final Logger logger = LoggerFactory.getLogger(TestRequestHeadController.class);

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

	@RequestMapping(value = "/view")
	public String viewCourse(String courseId, Map<String, Object> model) {
		logger.info("courseId:{}", courseId);
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");

		model.put("data", list);
		model.put("str", "hello");

		Map<String, Object> map = new HashMap<>();
		map.put("a", "A");
		return "view/test2/mapModel";
	}
}
