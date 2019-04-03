package com.atguigu.common.pojo.aop.math;

import org.junit.Test;

/**
 * @Author: lhh
 * @Date: 2019/4/3 20:44
 * @Version 1.0
 */
public class TestArithmeritCalculator {
    @Test
    public void fun1() {
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculatorImpl();
        int add = arithmeticCalculator.add(1, 2);
        System.out.println("--->" + add);
        int div = arithmeticCalculator.div(4, 2);

        System.out.println("--->" + div);
    }

    @Test
    public void funWithProxy() {
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculatorImpl();
        ArithmeticCalculator proxy =
                new ArithmeticCalculatorLogginProxy(arithmeticCalculator).getLogginProxy();
        int add = proxy.add(1, 2);
        System.out.println("--->" + add);
        int div = proxy.div(4, 2);

        System.out.println("--->" + div);
    }
}
