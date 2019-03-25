package com.atguigu.common.pojo;

/**
 * @author lhh
 * @date 2019/3/23 22:46
 * @Description: 测试spring的构造器注入方式
 */
public class Car {
    private String brand;
    private String corp;
    private int price;
    private double maxSpend;

    public Car(String brand, String corp, int price) {
        this.brand = brand;
        this.corp = corp;
        this.price = price;
    }

    public Car(String brand, String corp, double maxSpend) {
        this.brand = brand;
        this.corp = corp;
        this.maxSpend = maxSpend;
    }

    public Car(String brand, String corp, int price, double maxSpend) {
        this.brand = brand;
        this.corp = corp;
        this.price = price;
        this.maxSpend = maxSpend;
    }

    public Car() {
        System.out.println("Car类的无参构造器");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCorp() {
        return corp;
    }

    public void setCorp(String corp) {
        this.corp = corp;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getMaxSpend() {
        return maxSpend;
    }

    public void setMaxSpend(double maxSpend) {
        this.maxSpend = maxSpend;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", corp='" + corp + '\'' +
                ", price=" + price +
                ", maxSpend=" + maxSpend +
                '}';
    }
}
