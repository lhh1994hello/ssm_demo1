package com.atguigu.crud.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author lhh
 * @date 2019/4/11 17:50
 * @Description:
 */
@Component
@Aspect
public class TimeConsumeAspect {
    private static final Logger logger = LoggerFactory.getLogger(TimeConsumeAspect.class);

    @Pointcut("execution(public * com.atguigu.crud.service..*(..))")
    public void aopCheck() {

    }
    //@Pointcut(value = "execution(public  int  com.atguigu.common.pojo.aop.math2.ArithmeticCalculator2.*(..))")
    @Pointcut(value = "execution(public * com.atguigu.crud.controller.EmployeeController.*(..))")
    public void declareJoinpointExpress() {

    }

    @Before(value = "declareJoinpointExpress()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> argsList = Arrays.asList(joinPoint.getArgs());
        System.out.println("验证--》前置通知:methodName:" + methodName + ",参数:" + argsList);
    }
}
