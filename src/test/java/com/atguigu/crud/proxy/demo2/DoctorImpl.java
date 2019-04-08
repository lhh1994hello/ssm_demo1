package com.atguigu.crud.proxy.demo2;

/**
 * @author lhh
 * @date 2019/4/8 9:04
 * @Description:
 */
public class DoctorImpl implements Doctor {
    @Override
    public void say(String name) {
        System.out.println("hello:" + name);
    }
}
