package com.atguigu.common.pojo.factory;

/**
 * @author lhh
 * @date 2019/3/24 21:31
 * @Description:
 */
public class FactoryDemo {
    private String brand;
    private double price;

    public FactoryDemo() {
    }

    public FactoryDemo(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "FactoryDemo{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
