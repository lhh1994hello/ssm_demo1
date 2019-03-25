package com.atguigu.demo.spring;

import com.atguigu.common.pojo.cycle.PojoDemo01;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lhh
 * @date 2019/3/24 20:30
 * @Description:
 */
public class BeanLifeDemo03 {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/beans-autowired.xml");

    @Test
    public void fun1() {
        PojoDemo01 pojoDemo01 = (PojoDemo01) context.getBean("pojoDemo01");
        System.out.println(pojoDemo01);
        context.close();
    }
}
