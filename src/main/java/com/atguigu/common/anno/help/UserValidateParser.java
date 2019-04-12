package com.atguigu.common.anno.help;

import com.atguigu.common.anno.UserValidate;

import java.lang.reflect.Field;

/**
 * @author lhh
 * @date 2019/4/12 11:30
 * @Description: 自定义注解解析器
 * https://www.cnblogs.com/liangweiping/p/3837332.html
 */
public class UserValidateParser {

    public static boolean check2(AnnoUser user) {
        Class<? extends AnnoUser> aClass = user.getClass();

        if (user == null) {
            System.out.println("！！校验对象为空！！");
            return false;
        }
        Field[] fields = AnnoUser.class.getDeclaredFields();
        for (Field field : fields) {
            // 如果指定类型的注释存在于此元素上，则返回 true，否则返回 false。
            if (!field.isAnnotationPresent(UserValidate.class)) {
                //没有这个注解就直接返回true
                return true;
            }
            Class<UserValidate> userValidateClass = UserValidate.class;
            UserValidate validate = field.getAnnotation(UserValidate.class);

            if ("age".equals(field.getName())) {
                if (user.getAge() == null) {
                    if (validate.isNotNull()) {
                        System.out.println("！！年龄可空校验不通过：不可为空！！");
                        return false;
                    } else {
                        System.out.println("年龄可空校验通过：可以为空");
                        continue;
                    }
                }
            }
        }
        return true;
    }

    public static boolean check(AnnoUser user) {
        if (user == null) {
            System.out.println("！！校验对象为空！！");
            return false;
        }
        // 获取User类的所有属性（如果使用getFields，就无法获取到private的属性）
        Field[] fields = AnnoUser.class.getDeclaredFields();
        for (Field field : fields) {
            // 如果属性有注解，就进行校验
            if (field.isAnnotationPresent(UserValidate.class)) {
                UserValidate validate = field.getAnnotation(UserValidate.class);
                if (field.getName().equals("age")) {
                    if (user.getAge() == null) {
                        if (validate.isNotNull()) {
                            System.out.println("！！年龄可空校验不通过：不可为空！！");
                            return false;
                        } else {
                            System.out.println("年龄可空校验通过：可以为空");
                            continue;
                        }
                    } else {
                        System.out.println("年龄可空校验通过");
                    }

                    if (user.getAge().length() < validate.min()) {
                        System.out.println("！！年龄最小长度校验不通过！！");
                        return false;
                    } else {
                        System.out.println("年龄最小长度校验通过");
                    }

                    if (user.getAge().length() > validate.max()) {
                        System.out.println("！！年龄最大长度校验不通过！！");
                        return false;
                    } else {
                        System.out.println("年龄最大长度校验通过");
                    }
                }
                if (field.getName().equals("name")) {
                    if (user.getName() == null) {
                        if (validate.isNotNull()) {
                            System.out.println("！！名字可空校验不通过：不可为空！！");
                            return false;
                        } else {
                            System.out.println("名字可空校验通过：可以为空");
                            continue;
                        }
                    } else {
                        System.out.println("名字可空校验通过");
                    }

                    if (user.getName().length() < validate.min()) {
                        System.out.println("！！名字最小长度校验不通过！！");
                        return false;
                    } else {
                        System.out.println("名字最小长度校验通过");
                    }

                    if (user.getName().length() > validate.max()) {
                        System.out.println("！！名字最大长度校验不通过！！");
                        return false;
                    } else {
                        System.out.println("名字最大长度校验通过");
                    }
                }
            }
        }
        return true;
    }
}
