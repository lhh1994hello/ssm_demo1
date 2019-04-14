package com.atguigu.crud.controller.test;

import com.atguigu.crud.util.Msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: lhh
 * @Date: 2019/4/14 10:32
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/listener")
public class ListenerController {
    Logger logger = LoggerFactory.getLogger(ListenerController.class);

    @RequestMapping(value = "/requestListener")
    public Msg requestListener(HttpServletRequest request) {
        logger.info("测试Request监听器.......");
        request.setAttribute("a", "A");
        request.setAttribute("a", "B");
        request.removeAttribute("a");
        return Msg.Success();
    }

    @RequestMapping(value = "/sessionListener")
    public Msg sessionListener(HttpSession session) {
        logger.info("测试session监听器.......");
        session.setAttribute("hello", "world");

        return Msg.Success();
    }

    @RequestMapping(value = "/quit")
    public Msg quit(HttpSession session) {
        logger.info("销毁session.......");
        session.invalidate();
        return Msg.Success().add("message", "销毁session");
    }

}
