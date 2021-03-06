package com.atguigu.demo.spring.bean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.common.pojo.beanlife.BeanLife;

//作者:lhh 创建时间:2019年3月27日 上午9:28:04 

/**
 * 测试bean生命周期
 *
 * @author lhh
 */
public class BeanLifeDemo7 {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/ioc/bean-life.xml");

    @Test
    public void fun1() {
        BeanLife beanLife = context.getBean(BeanLife.class);
        Object filterChainDefinitionMap = context.getBean("filterChainDefinitionMap");

        System.out.println(beanLife);
        System.out.println("测试:" + filterChainDefinitionMap);
        context.close();

    }
}
