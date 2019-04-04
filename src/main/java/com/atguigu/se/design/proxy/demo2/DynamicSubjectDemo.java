package com.atguigu.se.design.proxy.demo2;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author lhh
 * @date 2019/4/4 9:59
 * @Description:
 */
public class DynamicSubjectDemo {

    @Test
    public void fun1() {
        DynamicSubject subject = new DynamicSubjectImpl();
        ClassLoader classLoader = subject.getClass().getClassLoader();
        InvocationHandler handler = new DynamicSubjectProxy(subject);
        // ClassLoader classLoader = handler.getClass().getClassLoader();
        //Class<?>[] interfaces = subject.getClass().getInterfaces();
        Class<?>[] interfaces = new Class[]{DynamicSubject.class};
        DynamicSubject proxy = (DynamicSubject) Proxy.newProxyInstance(classLoader, interfaces, handler);

        proxy.request("张三");
        //System.out.println(proxy);
    }
}
