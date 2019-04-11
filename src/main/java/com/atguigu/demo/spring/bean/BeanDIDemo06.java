package com.atguigu.demo.spring.bean;

import com.atguigu.common.pojo.di.DIUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanDIDemo06 {

    @Test
    public void fun1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/ioc/beans-di.xml");
        //DIUserService dIUserService = (DIUserService) context.getBean(DIUserService.class);
        DIUserService dIUserService = (DIUserService) context.getBean("DIUserService");
        dIUserService.add();
    }
}
