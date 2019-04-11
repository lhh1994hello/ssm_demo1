package com.atguigu.demo.spring.bean;

import com.atguigu.common.pojo.*;
import com.atguigu.common.pojo.other.Book;
import com.atguigu.common.pojo.other.DataSourcePojo;
import com.atguigu.common.pojo.other.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

//作者:lhh 创建时间:2019年3月23日 下午10:12:37 
public class SpringDemo01 {
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config/ioc/applicationTest.xml");

    @Test
    public void DogDemo() {
        Dog dog1 = (Dog) ctx.getBean("dog");
        //Dog dog2 = ctx.getBean(Dog.class);//容器中同一类型的对象只能有一个bean
        System.out.println(dog1);
        //System.out.println(dog2);
    }

    @Test
    public void carDemo() {
        Car car = (Car) ctx.getBean("car");
        Car car2 = (Car) ctx.getBean("car2");
        Car car3 = (Car) ctx.getBean("car3");
        System.out.println(car);
        System.out.println(car2);
        System.out.println(car3);
    }

    @Test
    public void personDemo() {
        Person person = (Person) ctx.getBean("person");
        Person person2 = (Person) ctx.getBean("person2");
        Person person3 = (Person) ctx.getBean("person3");
        Person person4 = (Person) ctx.getBean("person4");
        Person person5 = (Person) ctx.getBean("person5");
        System.out.println(person);
        System.out.println(person2);
        System.out.println(person3);
        System.out.println(person4);
        System.out.println(person5);

    }

    @Test
    public void bookDemo() {
        Book book = (Book) ctx.getBean("book");
        Book book2 = (Book) ctx.getBean("book2");
        Book book3 = (Book) ctx.getBean("book3");
        System.out.println(book);
        System.out.println(book2);
        System.out.println(book3);
    }

    @Test
    public void dataSourcePojoDemo() {
        DataSourcePojo dataSourcePojo = ctx.getBean(DataSourcePojo.class);
        System.out.println(dataSourcePojo);
        Map<String, Object> map = new HashMap<>();
        map.put("a", "A");
        map.put("b", "B");
        map.put("c", "C");
        System.out.println(map);
    }
}
