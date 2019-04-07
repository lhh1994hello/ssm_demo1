package com.atguigu.common.pojo.aop.math3;

import com.atguigu.common.pojo.aop.math2.ArithmeticCalculator2;
import org.springframework.stereotype.Component;

/**
 * @Author: lhh
 * @Date: 2019/4/7 15:57
 * @Version 1.0
 * 测试基于XML方式配置AOP
 */
@Component
public class ArithmeticCalculatorXMLImpl implements ArithmeticCalculatorXML {
    @Override
    public int add(int i, int j) {
        int result = i + j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        return result;
    }
}
