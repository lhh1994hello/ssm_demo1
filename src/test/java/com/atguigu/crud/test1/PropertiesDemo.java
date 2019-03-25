package com.atguigu.crud.test1;

import org.junit.Test;

import java.util.Properties;

/**
 * @author lhh
 * @date 2019/3/24 11:09
 * @Description:
 */
public class PropertiesDemo {
    @Test
    public void fun1() {
        Properties properties = new Properties();
        properties.setProperty("a", "A");
        properties.setProperty("b", "B");
        System.out.println(properties);
    }
}
