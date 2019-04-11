package com.atguigu.crud.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

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

    @Before("aopCheck()")
    public void beforeCheck(JoinPoint joinPoint) {
        // 获取到类名
        String targetName = joinPoint.getTarget().getClass().getName();
        // 获取到方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取到参数
        Object[] parameter = joinPoint.getArgs();
        logger.info("类名:{},方法名:{},形参:{}", targetName, methodName, Arrays.toString(parameter));
        System.out.println("前置增强...beforeCheck()");
    }
}
