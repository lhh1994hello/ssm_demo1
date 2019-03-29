package com.atguigu.demo.spring.aop;

import com.atguigu.common.pojo.aop.login.LoginMaster;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lhh
 * @date 2019/3/29 15:23
 * @Description:
 */
public class LoginAOPDemo {

    ApplicationContext context =
            new ClassPathXmlApplicationContext("config/aop/spring-login-aop.xml");

    //测试aop
    @Test
    public void fun1() {
        LoginMaster loginMaster = (LoginMaster) context.getBean("loginMaster");
        //loginMaster.findAll();
        loginMaster.addMethod("hello");
    }

}
