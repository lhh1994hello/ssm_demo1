package com.atguigu.se.classloader.help;

import java.util.Date;

/**
 * @author lhh
 * @date 2019/4/10 16:25
 * @Description:
 */
public class Vegetable {
    public static String VAGENAME = "有机花菜";
    public static final Integer COUNT = 10;
    private  String name;

    public Vegetable(String name) {
        this.name = name;
    }

    static {
        System.out.println("静态代码块...");
    }

//    public Vegetable() {
//        System.out.println("Vegetable的无参构造器...");
//    }

    public static void say() {
        System.out.println("静态方法:say" + new Date().getTime());
    }
}
