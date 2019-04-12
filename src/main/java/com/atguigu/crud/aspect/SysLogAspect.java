package com.atguigu.crud.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

/**
 * @author lhh
 * @date 2019/4/12 10:09
 * @Description: 系统日志
 */
@Aspect
@Order(2)
@Component
public class SysLogAspect {
    //@Pointcut("execution(public * com.atguigu.crud..*.*(..))")
    @Pointcut("@annotation(com.atguigu.common.anno.SysLog)")
    public void aopCheck() {
        System.out.println("表达式包....");
    }

    @Before(value = "aopCheck()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        //获得class对象，就可以通过反射做各种功能了
        Class<?> clazz = joinPoint.getTarget().getClass();
        Annotation[] annotations = clazz.getAnnotations();
        System.out.println("测试sysLog注解...:" + methodName);
    }
}
