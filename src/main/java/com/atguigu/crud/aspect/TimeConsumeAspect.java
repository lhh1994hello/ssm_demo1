package com.atguigu.crud.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author lhh
 * @date 2019/4/11 17:50
 * @Description:
 */
@Component
@Aspect
@Order(1)
public class TimeConsumeAspect {
    private static final Logger logger = LoggerFactory.getLogger(TimeConsumeAspect.class);

    //com.atguigu.crud包及其子包下所有类的所有方法
    @Pointcut("execution(public * com.atguigu.crud..*.*(..))")
    public void aopCheck() {
        System.out.println("表达式包....");
    }


    @Before(value = "aopCheck()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
    }

    //环绕通知，必须有返回值
    @Around("aopCheck()")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        String methodName = proceedingJoinPoint.getSignature().getName();//方法名
        Object[] args = proceedingJoinPoint.getArgs();//形参列表
        String simpleClassName = proceedingJoinPoint.getTarget().getClass().getSimpleName();//简单类名
        try {
            long startTime = System.currentTimeMillis();
            //前置通知
            // System.out.println("***环绕通知-前置通知:" + methodName);
            //logger.info("***环绕通知-前置通知:{},{}", methodName, Arrays.toString(args));
            result = proceedingJoinPoint.proceed();//执行目标方法
            // System.out.println("***环绕通知-返回通知:" + methodName);
            //logger.info("***环绕通知-返回通知:{},{}", methodName, Arrays.toString(args));
            long endTime = System.currentTimeMillis();
            long consumeTIme = endTime - startTime;
            logger.info("类:{}方法:{},参数是:{},执行用时:{} 毫秒", simpleClassName, methodName, Arrays.toString(args), consumeTIme);
            System.out.println("类:" + simpleClassName + "方法:" + methodName + "用时：" + consumeTIme + " 毫秒");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //System.out.println("***环绕通知-异常通知:" + methodName);
            //logger.info("***环绕通知-异常通知:{},{}", methodName, Arrays.toString(args));
            throw new RuntimeException(throwable);
        }
        //System.out.println("***环绕通知-后置通知:" + methodName);
        //logger.info("***环绕通知-后置通知:{},{}", methodName, Arrays.toString(args));
        return result;
    }
}
