package com.atguigu.crud.test.test1;

import org.junit.Test;

/**
 * @author lhh
 * @date 2019/4/20 15:09
 * @Description: 测试位运算
 */
public class BitOperationDemo {
    @Test
    public  void  fun1(){
        int default_initial_capacity = 1 << 4;
        int maximum_capacity = 1 << 30;
        System.out.println(default_initial_capacity);
        System.out.println(maximum_capacity);
    }
}
