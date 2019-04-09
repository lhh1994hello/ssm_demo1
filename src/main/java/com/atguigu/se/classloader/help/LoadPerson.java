package com.atguigu.se.classloader.help;

/**
 * @author lhh
 * @date 2019/4/9 14:52
 * @Description:
 */
public class LoadPerson {
    private String name;

    public LoadPerson(String name) {
        System.out.println("LoadPerson被加载了...");
        this.name = name;
    }

    public LoadPerson() {
        System.out.println("LoadPerson无参数构造器。。。。");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LoadPerson{" +
                "name='" + name + '\'' +
                '}';
    }
}
