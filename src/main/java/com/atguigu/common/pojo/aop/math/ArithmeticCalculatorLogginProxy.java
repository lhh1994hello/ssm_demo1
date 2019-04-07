package com.atguigu.common.pojo.aop.math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Author: lhh
 * @Date: 2019/4/3 20:53
 * @Version 1.0
 * 使用动态代理切入日志功能
 */
public class ArithmeticCalculatorLogginProxy {
    private static final Logger logger = LoggerFactory.getLogger(ArithmeticCalculatorLogginProxy.class);
    //要代理的对象
    private ArithmeticCalculator target;

    public ArithmeticCalculatorLogginProxy(ArithmeticCalculator target) {
        this.target = target;
    }

    public ArithmeticCalculatorLogginProxy() {
    }

    public ArithmeticCalculator getLogginProxy() {
        ArithmeticCalculator proxy = null;
        //代理对象由哪一个类加载器负责加载
        ClassLoader loader = target.getClass().getClassLoader();
        //代理对象的类型，即其中有哪些方法
        Class[] interfaces = new Class[]{ArithmeticCalculator.class};
        //当调用代理对象中的方法时，该执行的代码
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
               // System.out.println("进入了...");
               // System.out.println(proxy.toString());
                String methodName = method.getName();
                logger.info("the method is.:" + methodName + "  begin with :" + Arrays.asList(args));
               // System.out.println("执行了invoke.....");
                Object result = method.invoke(target, args);
                logger.info("the method is.:" + methodName + "  end with :" + Arrays.asList(args));
                return result;
            }
        };
        proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
        return proxy;
    }
}
