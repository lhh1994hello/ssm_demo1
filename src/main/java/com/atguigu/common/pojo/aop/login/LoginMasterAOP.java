package com.atguigu.common.pojo.aop.login;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author lhh
 * @date 2019/3/29 15:16
 * @Description: 增强体, 切面通常是一个类
 */

@Aspect
public class LoginMasterAOP {
    private static final Logger logger = LoggerFactory.getLogger(LoginMaster.class);

    @Pointcut("execution(public * com.atguigu.common..*(..))")
    public void aopCheck() {
        System.out.println("表达式...");
    }

    //前置增强
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

    //后置增强
    @After("aopCheck()")
    public void afterCheck() {
        System.out.println("后置增强...afterCheck()");
    }

    //声明围绕通知
    @Around("aopCheck()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {

        // 获取到类名
        String targetName = pjp.getTarget().getClass().getName();
        // 获取到参数
        Object[] parameter = pjp.getArgs();
        // 获取到方法签名，进而获得方法
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();

        logger.info("类名:{},形参:{}", targetName, Arrays.toString(parameter));
        System.out.println("增强的方法名字是:" + method.getName());
        System.out.println("进入方法---围绕通知---------doAround()");
        Object o = pjp.proceed();
        System.out.println("退出方法---围绕通知---------doAround()");


        return o;
    }
}
