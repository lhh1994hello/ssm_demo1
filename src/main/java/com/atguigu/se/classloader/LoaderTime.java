package com.atguigu.se.classloader;

import com.atguigu.se.classloader.help.Vegetable;
import org.junit.Test;

/**
 * @author lhh
 * @date 2019/4/10 16:23
 * @Description: 测试类加载时机
 */
public class LoaderTime {
    @Test
    public void fun1() throws ClassNotFoundException {
        //String vagename = Vegetable.VAGENAME;
        //    System.out.println("值:" + vagename);
        Vegetable.say();
       // Integer count = Vegetable.COUNT;
        Class.forName("com.atguigu.se.classloader.help.Vegetable");

    }

}
