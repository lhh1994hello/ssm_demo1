package com.atguigu.common.pojo.annotation.controller;

import com.atguigu.common.pojo.annotation.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author lhh
 * @date 2019/3/24 22:57
 * @Description:
 */
@Controller
public class TestUserController {


    public TestUserController() {
        System.out.println("构造器,TestUserController");
    }

    @Autowired
    private TestUserService userService;

    public void execute() {
        System.out.println("TestUserController 的execute方法...");
        userService.add();
    }
}
