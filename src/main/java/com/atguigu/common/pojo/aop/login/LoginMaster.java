package com.atguigu.common.pojo.aop.login;

import org.springframework.stereotype.Component;

/**
 * @author lhh
 * @date 2019/3/29 15:12
 * @Description: 模拟登陆时被AOP增强
 */
@Component
public class LoginMaster {

    public void login() {
        System.out.println("正在登陆...login()");
    }

    public void addMethod(String str) {
        System.out.println("增加用户方法...addMethod()," + str);
    }

    public void findAll() {
        System.out.println("查询所有用户方法...findAll()");
    }
}
