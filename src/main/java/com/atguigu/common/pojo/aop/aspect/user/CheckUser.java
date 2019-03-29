package com.atguigu.common.pojo.aop.aspect.user;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author lhh
 * @date 2019/3/29 14:41
 * @Description:
 */
@Aspect
public class CheckUser {
    @Pointcut("execution(public * com.atguigu..*(..))")
    public void checkUser(){
        System.out.println("**************The System is Searching Information For You****************");
    }

//    @Pointcut("execution(* com.tgb.spring.aop.*.add*(..))")
//    public void checkAdd(){
//        System.out.println("**************<< Add User >> Checking.....***************");
//    }
    

    @Before("checkUser()")
    public void beforeCheck(){
        System.out.println(">>>>>>>> 准备搜查用户..........beforeCheck()");
    }

    @After("checkUser()")
    public void afterCheck(){
        System.out.println(">>>>>>>>　搜查用户完成..........afterCheck()");
    }

    @Before("checkUser()")
    public void beforeAdd(){
        System.out.println(">>>>>>>>　添加用户--检查ing..........beforeAdd(){");
    }

    @After("checkUser()")
    public void afterAdd(){
        System.out.println(">>>>>>>>　添加用户--检查完成！ 未发现异常!..........afterAdd()");
    }

    //声明围绕通知
    @Around("checkUser()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("进入方法---围绕通知---------doAround()");
        Object o = pjp.proceed();
        System.out.println("退出方法---围绕通知---------doAround()");
        return o;
    }
}
