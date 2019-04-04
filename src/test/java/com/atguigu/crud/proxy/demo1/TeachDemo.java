package com.atguigu.crud.proxy.demo1;

import org.junit.Test;

/**
 * @author lhh
 * @date 2019/4/4 11:38
 * @Description:
 */
public class TeachDemo {
    @Test
    public void fun1() {
        Teach teach = new TeachImpl();
        Teach proxy = new TeachProxy(teach).getTeachProxy();
        proxy.teachStudent("小明");
    }
}
