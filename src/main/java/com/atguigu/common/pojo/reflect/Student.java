package com.atguigu.common.pojo.reflect;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Serializable;

/**
 * @author lhh
 * @date 2019/3/25 10:06
 * @Description: 反射测试pojo
 */
@Component
@SuppressWarnings("all")
@RequestMapping(value = "/student", method = {RequestMethod.GET, RequestMethod.POST})
public class Student implements StuInterface, Serializable {
    @Value("${qinuiyun.bucketname}")
    private String qiniuyunBucketname;

    private String name;
    private String sex;
    private int age;
    public String classc;

    public String getClassc() {
        return classc;
    }

    public void setClassc(String classc) {
        this.classc = classc;
    }

    public Student() {
        System.out.println("");
    }


    public Student(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    private Student(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void add() {
        System.out.println("add方法...");
    }
}
