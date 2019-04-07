package com.atguigu.demo.spring.aop;

import com.atguigu.common.pojo.aop.math.ArithmeticCalculator;
import com.atguigu.common.pojo.aop.math.ArithmeticCalculatorImpl;

public class ArithmeticCalculatorTest {
    public static void main(String[] args) {
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculatorImpl();
        int add = arithmeticCalculator.add(1, 2);
        int sub = arithmeticCalculator.sub(5, 2);
        int mul = arithmeticCalculator.mul(3, 5);
        int div = arithmeticCalculator.div(15, 5);
        System.out.println("add:" + add);
        System.out.println("sub:" + sub);
        System.out.println("mul:" + mul);
        System.out.println("div:" + div);
    }
}
