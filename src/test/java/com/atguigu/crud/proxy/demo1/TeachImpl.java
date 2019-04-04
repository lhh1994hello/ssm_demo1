package com.atguigu.crud.proxy.demo1;

/**
 * @author lhh
 * @date 2019/4/4 11:28
 * @Description:
 */
public class TeachImpl implements Teach {
    @Override
    public void teachStudent(String studentName) {
        System.out.println("教学，学生名称是:" + studentName);
    }
}
