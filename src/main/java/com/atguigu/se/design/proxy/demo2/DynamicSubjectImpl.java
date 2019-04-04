package com.atguigu.se.design.proxy.demo2;

/**
 * @author lhh
 * @date 2019/4/4 9:54
 * @Description: 被代理的类
 */
public class DynamicSubjectImpl implements DynamicSubject {

    @Override
    public void request(String name) {
        System.out.println("执行真是角色...:" + name);
    }
}
