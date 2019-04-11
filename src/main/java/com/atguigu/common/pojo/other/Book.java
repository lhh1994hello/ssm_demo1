package com.atguigu.common.pojo.other;

import com.atguigu.common.pojo.Car;

import java.util.List;
import java.util.Map;

/**
 * @author lhh
 * @date 2019/3/24 10:40
 * @Description:
 */
public class Book {
    private String name;
    private int age;
    private List<Car> cars;
    private Map<String, Car> mapCars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Map<String, Car> getMapCars() {
        return mapCars;
    }

    public void setMapCars(Map<String, Car> mapCars) {
        this.mapCars = mapCars;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                ", mapCars=" + mapCars +
                '}';
    }
}
