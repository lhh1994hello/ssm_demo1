package com.atguigu.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crud.service.ThreadService;
import com.atguigu.crud.util.Msg;

//作者:lhh 创建时间:2018年11月12日 下午12:23:47 
@Controller
@RequestMapping(value = "/thread")
public class ThreadController {
	@Autowired
	private ThreadService threadService;

	@ResponseBody
	@RequestMapping(value = "/threadFun1")
	public Msg threadFun1() {
		System.out.println("测试线程同步.......");
		try {
			threadService.threadFun1();
		} catch (Exception e) {
			System.out.println("操作失败...........");
		}
		return Msg.Success();
	}

}
