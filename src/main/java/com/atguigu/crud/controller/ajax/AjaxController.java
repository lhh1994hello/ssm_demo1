package com.atguigu.crud.controller.ajax;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crud.util.Msg;

//作者:lhh 创建时间:2018年11月17日 下午9:09:32 
@Controller
@RequestMapping(value = "/ajax")
public class AjaxController {
	Logger logger = LoggerFactory.getLogger(AjaxController.class);

	@ResponseBody
	@RequestMapping(value = "/ajaxTest1")
	public Msg ajaxTest1(String a,String b) throws InterruptedException {
		logger.info("测试ajax使用...");
		Thread.sleep(2000);
		return Msg.Success();
	}
}
