package com.atguigu.common.pojo.cycle;

/**
 * @author lhh
 * @date 2019/3/24 18:16
 * @Description:
 */
public class PojoDemo01 {
    private String brand;

    public PojoDemo01() {
        System.out.println("PojoDemo01 无参构造器...");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void init() {
        System.out.println("init初始化方法...");
    }

    public void destroy() {
        System.out.println("destroy销毁方法...");
    }

}
