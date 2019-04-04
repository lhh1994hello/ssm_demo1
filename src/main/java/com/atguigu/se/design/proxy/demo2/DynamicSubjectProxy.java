package com.atguigu.se.design.proxy.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author lhh
 * @date 2019/4/4 9:55
 * @Description: 代理类
 */
public class DynamicSubjectProxy implements InvocationHandler {

    private Object target;

    public DynamicSubjectProxy(Object target) {
        this.target = target;
    }

    public DynamicSubjectProxy() {
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //执行System.out.println(proxy);时，会调用toString方法，该方法没有参数，args为空，Arrays.asList(args)会报错
        String methodName = method.getName();
        System.out.println("方法执行前:" + methodName + ",参数:" + Arrays.asList(args));
        Object invoke = method.invoke(target, args);
        System.out.println("方法执行后:" + methodName + ",参数:" + Arrays.asList(args));
        return invoke;
    }

}
