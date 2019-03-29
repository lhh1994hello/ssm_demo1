package com.atguigu.demo.spring.aop;

import com.atguigu.common.pojo.aop.aspect.user.IUser;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lhh
 * @date 2019/3/29 14:48
 * @Description:
 */
public class IUAOPDemo01 {
    ApplicationContext context = new ClassPathXmlApplicationContext("config/aop/spring-aop01.xml");

    @Test
    public void fun1() {
        IUser user = (IUser) context.getBean("iUser");
        user.findAll();
    }
}
