package com.atguigu.se.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lhh
 * @date 2019/3/25 10:34
 * @Description: 使用反射操作方法求和，传参数
 */
public class InvokeTest {
    public int add(int param1, int param2) {
        return param1 + param2;
    }

    public String sayHello(String s) {
        return "hello:" + s;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<InvokeTest> clazzName = InvokeTest.class;
        InvokeTest invokeTest = clazzName.newInstance();
        Method addMethod = clazzName.getMethod("add", new Class[]{int.class, int.class});//也可以写成下面形式
        Method sayHelloMethod = clazzName.getMethod("sayHello", String.class);

        Object resultAdd = addMethod.invoke(invokeTest, new Object[]{5, 8});
        Object resultStr = sayHelloMethod.invoke(invokeTest, "张三");

        System.out.println(resultAdd);
        System.out.println(resultStr);

    }
}
