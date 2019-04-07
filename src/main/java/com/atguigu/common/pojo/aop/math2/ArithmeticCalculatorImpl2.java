package com.atguigu.common.pojo.aop.math2;

import org.springframework.stereotype.Component;

/**
 * @Author: lhh
 * @Date: 2019/4/7 15:57
 * @Version 1.0
 */
@Component
public class ArithmeticCalculatorImpl2 implements ArithmeticCalculator2 {
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
