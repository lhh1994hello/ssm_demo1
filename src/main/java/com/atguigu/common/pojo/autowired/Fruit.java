package com.atguigu.common.pojo.autowired;

/**
 * @author lhh
 * @date 2019/3/24 14:59
 * @Description:
 */
public class Fruit {
    private String brand;
    private double price;

    public Fruit() {
        System.out.println("Fruit无参构造器***");
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
        return "Fruit{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
