package com.atguigu.demo.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: lhh
 * @Date: 2019/4/7 20:02
 * @Version 1.0
 * 验证切面
 */
@Order(1)
@Aspect
public class ValidationAspect {
    //声明切入点表达式
    //@Pointcut(value = "execution(public  int  com.atguigu.common.pojo.aop.math2.ArithmeticCalculator2.*(..))")
    @Pointcut(value = "execution(public * com.atguigu.common.pojo.aop.math2.ArithmeticCalculator2.*(..))")
    public void declareJoinpointExpress() {

    }

    @Before(value = "declareJoinpointExpress()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> argsList = Arrays.asList(joinPoint.getArgs());
        System.out.println("验证--》前置通知:methodName:" + methodName + ",参数:" + argsList);
    }
}
