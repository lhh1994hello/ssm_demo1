package com.atguigu.se.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lhh
 * @date 2019/4/2 9:59
 * @Description: 动态代理
 */
public class ProxyHandlerDemo implements InvocationHandler {
    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("动态代理：ProxyHandler before~~");
        result = method.invoke(target, args);
        System.out.println("动态代理：ProxyHandler after~~");
        return result;
    }
}
