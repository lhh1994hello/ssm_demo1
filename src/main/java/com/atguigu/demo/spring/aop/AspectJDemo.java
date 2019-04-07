package com.atguigu.demo.spring.aop;

import com.atguigu.common.pojo.aop.math2.ArithmeticCalculator2;
import com.atguigu.common.pojo.aop.math3.ArithmeticCalculatorXML;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: lhh
 * @Date: 2019/4/7 12:04
 * @Version 1.0
 */
public class AspectJDemo {
    ApplicationContext context = new ClassPathXmlApplicationContext("config/aop/spring-aspectj.xml");
    ApplicationContext xmlContext = new ClassPathXmlApplicationContext("config/aop/spring-aspectj-xml.xml");


    @Test
    public void aopWithAnno() {
        ArithmeticCalculator2 arithmeticCalculator2 = context.getBean(ArithmeticCalculator2.class);
        System.out.println("类:" + arithmeticCalculator2.getClass().getName());

        int add = arithmeticCalculator2.add(3, 2);
        System.out.println("结果:" + add);
        System.out.println("**************************************************");
        int mul = arithmeticCalculator2.div(2, 1);
        System.out.println("相减:" + mul);
    }

    @Test
    public void aopWithXML() {
        ArithmeticCalculatorXML arithmeticCalculatorXML = (ArithmeticCalculatorXML) xmlContext.getBean("arithmeticCalculatorXML");
        int add = arithmeticCalculatorXML.add(3, 4);
        System.out.println("add:" + add);
        System.out.println("*****************************************");

        int div = arithmeticCalculatorXML.div(4, 0);
        System.out.println("相除:"+div);

    }
}
