package com.atguigu.se.reflect;

import org.junit.Test;
import org.springframework.stereotype.Component;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author lhh
 * @date 2019/3/25 10:00
 * @Description: 反射入门
 */
public class ReflectDemo01 {
    @Test
    public void fun1() throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {
        Class<?> clazzName = Class.forName("com.atguigu.common.pojo.reflect.Student");
        String className = clazzName.getName();//全路径类型
        String simpleName = clazzName.getSimpleName();//类名，

        Annotation annotation = clazzName.getAnnotation(Component.class);
        Package aPackage = clazzName.getPackage();

        //获得公有构造器
        Constructor<?>[] constructors = clazzName.getConstructors();
        //获得所有构造器
        Constructor<?>[] declaredConstructors = clazzName.getDeclaredConstructors();
        //获得公有无参构造器
        Constructor<?> constructor = clazzName.getConstructor();
        //获得作用在类上面的注解
        Annotation[] annotations = clazzName.getAnnotations();
        //获得实现的接口
        Class<?>[] interfaces = clazzName.getInterfaces();
        //获得父类
        Class<?> superclass = clazzName.getSuperclass();
        //公有属性
        Field[] fields = clazzName.getFields();
        //获得所有属性
        Field[] declaredFields = clazzName.getDeclaredFields();
        //按属性名获得公有属性对象
        Field fieldName = clazzName.getField("classc");


        System.out.println("**************************************************");
        for (Constructor c : constructors) {
            System.out.println("公有构造器:" + c);
        }
        for (Constructor c : declaredConstructors) {
            System.out.println("所有构造器:" + c);
        }
        System.out.println("无参构造器:" + constructor);
        for (Annotation a : annotations) {
            System.out.println("注解列表:" + a);
        }
        for (Class i : interfaces) {
            System.out.println("接口:" + i);
        }
        for (Field f : fields) {
            System.out.println("公有属性:" + f);
        }
        for (Field f : declaredFields) {
            System.out.println("所有属性:" + f);
        }
        System.out.println("父类:" + superclass);
        System.out.println("fieldName:" + fieldName);
        System.out.println("全路径类名:" + className);
        System.out.println("类名:" + simpleName);
        System.out.println("包名:" + aPackage);
    }

}
