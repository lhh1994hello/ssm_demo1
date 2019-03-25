package com.atguigu.demo.spring;

import com.atguigu.common.pojo.Car;
import com.atguigu.common.pojo.Dog;
import com.atguigu.common.pojo.autowired.Address;
import com.atguigu.common.pojo.autowired.Citizen;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lhh
 * @date 2019/3/24 15:03
 * @Description:
 */
public class BeanAutowiredDemo02 {
    ApplicationContext context = new ClassPathXmlApplicationContext("config/beans-autowired.xml");

    @Test
    public void fun1() {
        Dog dog = (Dog) context.getBean("dog");
        System.out.println(dog);
    }

    @Test
    public void citizenDemo() {
        Citizen citizen = (Citizen) context.getBean("citizen");
        System.out.println(citizen);
    }

    @Test
    public void beanRelationDemo() {
        Address address01 = (Address) context.getBean("address01");
        Address address02 = (Address) context.getBean("address02");
        System.out.println(address01);
        System.out.println(address02);
    }

    //测试bean的作用域
    @Test
    public void carDemo() {
        ApplicationContext context2 = new ClassPathXmlApplicationContext("config/beans-autowired.xml");

//        Car car01 = (Car) context.getBean("car");
//        Car car02 = (Car) context.getBean("car");
//        System.out.println(car01 == car02);

    }
}
