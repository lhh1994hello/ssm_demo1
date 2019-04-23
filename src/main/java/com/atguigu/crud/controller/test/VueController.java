package com.atguigu.crud.controller.test;

import com.atguigu.crud.util.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: lhh
 * @Date: 2019/4/23 22:52
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/vue")
public class VueController {

    @ResponseBody
    @RequestMapping("getArray")
    public Msg getArray() {
        System.out.println("vue请求数据...");
        String[] array = {"1", "2", "3", "4", "5"};
        return Msg.Success().add("array", array);
    }
}
