package com.atguigu.demo.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: lhh
 * @Date: 2019/4/7 16:03
 * @Version 1.0
 * 日志切面，基于配置文件方式
 */

public class LoggingAspectWithXML {
    //前置通知，
    public void beforeMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        List<Object> argsList = Arrays.asList(args);
        System.out.println("前置通知:the method:" + name + "  begin..." + argsList);
    }

    //后置通知，在目标方法执行后(无论是否发生异常),执行的通知
    //在后置通知中，还不能访问目标方法的执行结果
    public void afterMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        List<Object> argsList = Arrays.asList(args);
        System.out.println("后置通知:the method:" + name + "  end..." + argsList);
    }

    //返回通知
    //在方法正常结束后执行的通知,出现异常就不执行了
    //返回通知是可以访问到方法的返回值的
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        List<Object> argsList = Arrays.asList(args);
        System.out.println("返回通知:the method:" + name + "  afterReturning..." + argsList + ",执行结果:" + result);
    }

    //异常通知,在目标方法出现异常时执行时会执行的代码
    //可以访问到异常对象，切可以指定在出现特地异常时，才执行通知代码
    //只需要把Exception替换成指定的异常类型即可，如NullPointException,只有发生空指针异常时才执行代码
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String name = joinPoint.getSignature().getName();
        System.out.println("异常通知:the method:" + name + "  afterThrowing..." + "ex:" + ex);
    }
}
