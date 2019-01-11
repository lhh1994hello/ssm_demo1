package com.atguigu.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//作者:lhh 创建时间:2018年10月20日 下午3:16:59 
@Controller
@RequestMapping(value = "/book")
public class BookController {
	@RequestMapping(value = "/fun1")
	public String fun1(RedirectAttributes redirectAttributes, Model model) {
		System.out.println("测试fun1");
		redirectAttributes.addAttribute("a", "A");
		redirectAttributes.addFlashAttribute("c", "C");
		model.addAttribute("b", "B");
		// return "redirect:/fun1.jsp";
		return "forward:/book/fun2";
	}
	
	@RequestMapping(value = "/fun2")
	public String fun2(RedirectAttributes redirectAttributes, Model model) {
		System.out.println("测试fun1");
		redirectAttributes.addAttribute("a", "A");
		redirectAttributes.addFlashAttribute("c", "C");
		model.addAttribute("b", "B");
		// return "redirect:/fun1.jsp";
		return "forward:/fun1.jsp";
	}
}
