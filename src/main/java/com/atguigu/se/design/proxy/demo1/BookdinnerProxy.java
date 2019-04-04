package com.atguigu.se.design.proxy.demo1;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author lhh
 * @date 2019/4/4 9:27
 * @Description: 动态代理
 */
public class BookdinnerProxy {
    //传入要代理的类
    private Bookdinner target;

    public BookdinnerProxy(Bookdinner target) {
        this.target = target;
    }
    public BookdinnerProxy() {
    }

    public Bookdinner getBookDinnerProxy() {
        Bookdinner proxy = null;
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class[] interfaces = new Class[]{Bookdinner.class};

        InvocationHandler h = new InvocationHandler() {
            /**
             * @param proxy :正在返回的那个代理对象，一般情况下在invoke方法中都不使用该方法
             * @param method:正在被调用的方法
             * @param args:调用方法时传入的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                System.out.println("订餐之前执行动作...:" + methodName + ":" + Arrays.asList(args));
                Object invoke = method.invoke(target, args);
                System.out.println("订餐之后执行动作...:" + methodName + ":" + Arrays.asList(args));
                return invoke;
            }
        };
        proxy = (Bookdinner) Proxy.newProxyInstance(classLoader, interfaces, h);
        return proxy;
    }
}
