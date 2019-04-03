package com.atguigu.common.pojo.aop.math;

public class ArithmeticCalculatorLogginImpl implements ArithmeticCalculator {
    @Override
    public int add(int i, int j) {
        System.out.println("the method add begin with[" + i + "," + j + "]");
        int result = i + j;
        System.out.println("the method add end with[" + i + "," + j + "]");
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("the method sub begin with[" + i + "," + j + "]");
        int result = i - j;
        System.out.println("the method sub end with[" + i + "," + j + "]");
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("the method mul begin with[" + i + "," + j + "]");
        int result = i * j;
        System.out.println("the method mul end with[" + i + "," + j + "]");
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("the method div begin with[" + i + "," + j + "]");
        int result = i / j;
        System.out.println("the method div end with[" + i + "," + j + "]");
        return result;
    }
}
