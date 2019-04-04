package com.atguigu.crud.lombok;

import org.junit.Test;

/**
 * @author lhh
 * @date 2019/4/3 15:40
 * @Description:
 */
public class TestLombok {
    @Test
    public  void  fun1(){
        LombokDemo01 lombokDemo01=new LombokDemo01();
        Integer age = lombokDemo01.getAge();
        

    }
}
