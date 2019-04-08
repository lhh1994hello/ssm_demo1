package com.atguigu.crud.proxy.demo2;

import org.junit.Test;

/**
 * @author lhh
 * @date 2019/4/8 9:09
 * @Description: 测试动态代理
 */
public class DoctorDemo {
    @Test
    public void fun1() {
        Doctor doctor = new DoctorImpl();
        Doctor proxy = new DoctorProxy(doctor).getDoctorProxy();
        String name = proxy.getClass().getName();

        System.out.println("对象名:" + name);
        proxy.say("张三");
    }
}
