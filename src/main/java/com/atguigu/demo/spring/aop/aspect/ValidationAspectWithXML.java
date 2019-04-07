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
 * 验证切面,基于配置文件方式
 */
public class ValidationAspectWithXML {

    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> argsList = Arrays.asList(joinPoint.getArgs());
        System.out.println("验证--》前置通知:methodName:" + methodName + ",参数:" + argsList);
    }
}
