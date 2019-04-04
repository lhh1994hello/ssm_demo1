package com.atguigu.crud.proxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author lhh
 * @date 2019/4/4 11:30
 * @Description:
 */
public class TeachProxy {
    private Teach target;

    public TeachProxy(Teach target) {
        this.target = target;
    }

    public Teach getTeachProxy() {
        Teach proxy = null;
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class[] interfaces = new Class[]{Teach.class};

        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
              //  System.out.println("正在返回的代理对象:" + proxy);
                String methodName = method.getName();
                System.out.println("执行前，方法名:" + methodName + ",参数:" + Arrays.toString(args));
                Object invoke = method.invoke(target, args);
                System.out.println("执行后，方法名:" + methodName + ",参数:" + Arrays.toString(args));
                return invoke;
            }
        };

        proxy = (Teach) Proxy.newProxyInstance(classLoader, interfaces, h);
        return proxy;
    }
}
