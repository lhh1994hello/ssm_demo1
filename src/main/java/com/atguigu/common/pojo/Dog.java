package com.atguigu.common.pojo;

//作者:lhh 创建时间:2019年3月19日 下午1:15:25 
public class Dog {
    private String name;
    private int age;

    public Dog() {
        System.out.println("Dog无参构造器***");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("dog的set方法:" + name);
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("dog的set方法:" + age);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog [name=" + name + ", age=" + age + "]";
    }

}
