package com.atguigu.crud.controller.test;

import com.atguigu.common.anno.SysLog;
import com.atguigu.crud.util.Msg;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lhh
 * @date 2019/4/12 10:13
 * @Description: 自定义注解，aop解析
 */
@RestController
@RequestMapping(value = "/aop")
public class AOPController {

    @SysLog
    @RequestMapping(value = "/sysLogAnnoDemo")
    public Msg sysLogAnnoDemo() {
        System.out.println("sysLogAnnoDemo方法...");
        return Msg.Success();
    }
}
