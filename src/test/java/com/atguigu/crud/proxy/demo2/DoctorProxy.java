package com.atguigu.crud.proxy.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lhh
 * @date 2019/4/8 9:04
 * @Description:
 */
public class DoctorProxy {
    public Doctor target;

    public DoctorProxy(Doctor target) {
        this.target = target;
    }

    public DoctorProxy() {
    }

    public Doctor getDoctorProxy() {
        Doctor proxy = null;
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class[] interfaces = new Class[]{Doctor.class};
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                System.out.println("方法执行前:" + methodName);
                Object invoke = method.invoke(target, args);
                System.out.println("方法执行后:" + methodName);
                return invoke;
            }
        };

        proxy = (Doctor) Proxy.newProxyInstance(classLoader, interfaces, h);
        return proxy;
    }
}
