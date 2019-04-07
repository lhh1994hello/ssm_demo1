package com.atguigu.demo.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: lhh
 * @Date: 2019/4/7 16:03
 * @Version 1.0
 * 日志切面
 */
@Order(2)
@Aspect
//@Component
public class LoggingAspect {

    //统一定义切入点表达式
    @Pointcut(value = "execution(public  int  com.atguigu.common.pojo.aop.math2.ArithmeticCalculator2.*(..))")
    public void pointcutMethod() {

    }

    //前置通知，
    //声明该方法是一个前置通知:在目标方法开始之前执行，
    //@Before("execution(public  int  com.atguigu.common.pojo.aop.math2.ArithmeticCalculator2.add(int ,int ))")
    @Before("pointcutMethod()")
    public void beforeMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        List<Object> argsList = Arrays.asList(args);
        System.out.println("前置通知:the method:" + name + "  begin..." + argsList);
    }

    //后置通知，在目标方法执行后(无论是否发生异常),执行的通知
    //在后置通知中，还不能访问目标方法的执行结果
    @After("pointcutMethod()")
    public void afterMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        List<Object> argsList = Arrays.asList(args);
        System.out.println("后置通知:the method:" + name + "  end..." + argsList);
    }

    //返回通知
    //在方法正常结束后执行的通知,出现异常就不执行了
    //返回通知是可以访问到方法的返回值的
    @AfterReturning(value = "pointcutMethod()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        List<Object> argsList = Arrays.asList(args);
        System.out.println("返回通知:the method:" + name +
                "  afterReturning..." + argsList + ",执行结果:" + result);
    }

    //异常通知,在目标方法出现异常时执行时会执行的代码
    //可以访问到异常对象，切可以指定在出现特地异常时，才执行通知代码
    //只需要把Exception替换成指定的异常类型即可，如NullPointException,只有发生空指针异常时才执行代码
    @AfterThrowing(value = "pointcutMethod()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String name = joinPoint.getSignature().getName();
        System.out.println("异常通知:the method:" + name + "  afterThrowing..." + "ex:" + ex);
    }

    //环绕通知
    /**
     * 环绕通知需要携带 ProceedingJoinPoint 类型的参数
     * 环绕通知类似动态代理的全过程，ProceedingJoinPoint类型的参数可以决定是否执行目标方法
     * 环绕通知必须有返回值，返回值即为目标方法的返回值
     */
//    @Around(value = "pointcutMethod()")
//    public Object aroundMehotd(ProceedingJoinPoint proceedingJoinPoint) {
//        Object result = null;
//        String methodName = proceedingJoinPoint.getSignature().getName();
//        try {
//            //前置通知
//            System.out.println("***环绕通知-前置通知:" + methodName);
//            result = proceedingJoinPoint.proceed();//执行目标方法
//            System.out.println("***环绕通知-返回通知:" + methodName);
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            System.out.println("***环绕通知-异常通知:" + methodName);
//            throw new RuntimeException(throwable);
//        }
//        System.out.println("***环绕通知-后置通知:" + methodName);
//        return result;
//    }
}
