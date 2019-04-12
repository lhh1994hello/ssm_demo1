package com.atguigu.common.anno.help;

import com.atguigu.common.anno.UserValidate;

/**
 * @author lhh
 * @date 2019/4/12 11:28
 * @Description:
 */
public class AnnoUser {
    @UserValidate(min = 2, max = 5)
    private String name;

    @UserValidate(isNotNull = false)
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "AnnoUser{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
