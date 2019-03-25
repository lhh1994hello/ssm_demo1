package com.atguigu.common.pojo.autowired;

/**
 * @author lhh
 * @date 2019/3/24 14:58
 * @Description:
 */
public class Address {
    private String city;
    private String street;

    public Address() {
        System.out.println("Address无参构造器***");
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
