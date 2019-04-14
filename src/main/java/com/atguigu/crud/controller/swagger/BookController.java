package com.atguigu.crud.controller.swagger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.util.Msg;

//作者:lhh 创建时间:2018年10月20日 下午3:16:59 
@Controller
@RequestMapping(value = "/book")
@SuppressWarnings("all")
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
        return "forward:/view/test/fun1.jsp";
    }

    // 查询员工、
    @ResponseBody
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    // 这个id是从路径中取出来的
    public Msg getEmp(@PathVariable("id") Integer id) {
        System.out.println("id=" + id);
        return Msg.Success().add("emp", "aaa");
    }
}
