package com.atguigu.demo.spring.bean;

import com.atguigu.common.pojo.autowired.Address;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lhh
 * @date 2019/3/24 21:05
 * @Description:
 */
public class BeanLifeDemo4 {

    @Test
    public void fun1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/lifecycle.xml");
        Address address= (Address) context.getBean("address");
        Address address2= (Address) context.getBean("address2");
        Address address22= (Address) context.getBean("address2");
        System.out.println(address==address2);
        System.out.println(address22==address2);
        context.close();

    }
}
