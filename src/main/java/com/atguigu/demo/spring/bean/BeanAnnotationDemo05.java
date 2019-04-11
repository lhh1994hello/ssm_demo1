package com.atguigu.demo.spring.bean;

import com.atguigu.common.pojo.annotation.controller.TestUserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lhh
 * @date 2019/3/24 23:00
 * @Description:
 */
public class BeanAnnotationDemo05 {

    @Test
    public void fun1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/ioc/beans-annotation.xml");
        TestUserController userController = context.getBean(TestUserController.class);
        userController.execute();
    }
}
