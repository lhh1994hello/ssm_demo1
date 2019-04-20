package com.atguigu.crud.controller.test;

import com.atguigu.crud.util.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

//作者:lhh 创建时间:2018年10月20日 下午2:44:19 
@RequestMapping(value = "/user")
@Controller
public class UserController {

    // 测试fun1
    @RequestMapping(value = "/fun1")
    public String fun1() {
        System.out.println("测试一下....fun1");
        return "redirect:/user/fun2";
    }

    @RequestMapping(value = "/fun2")
    public String fun2() {
        System.out.println("测试一下....fun2");
        return "view/test/fun1";
    }

    @ResponseBody
    @RequestMapping(value = "/layeditDemo")
    public Msg layeditDemo(HttpServletRequest request) {

        String layEdit = request.getParameter("layEdit");
        String username = request.getParameter("username");

        return Msg.Success();
    }
}
