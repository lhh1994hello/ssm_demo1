package com.atguigu.common.pojo.autowired;

import com.atguigu.common.pojo.autowired.Address;
import com.atguigu.common.pojo.autowired.Fruit;

/**
 * @author lhh
 * @date 2019/3/24 15:01
 * @Description:
 */
public class Citizen {
    private String name;
    private Fruit fruit;
    private Address address;

    public Citizen() {
        System.out.println("Citizen无参构造器***");
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address123) {
        this.address = address123;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                ", fruit=" + fruit +
                ", address=" + address +
                '}';
    }
}
