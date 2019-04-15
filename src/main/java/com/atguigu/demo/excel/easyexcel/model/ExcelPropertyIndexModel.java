package com.atguigu.demo.excel.easyexcel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @author lhh
 * @date 2019/4/15 10:10
 * @Description: excel实体类
 */
public class ExcelPropertyIndexModel extends BaseRowModel {
    @ExcelProperty(value = "姓名", index = 0)
    public String name;

    @ExcelProperty(value = "年龄", index = 1)
    public String age;

    @ExcelProperty(value = "邮箱", index = 2)
    public String email;

    @ExcelProperty(value = "地址", index = 3)
    public String address;

    @ExcelProperty(value = "性别", index = 4)
    public String sax;

    @ExcelProperty(value = "高度", index = 5)
    public String heigh;

    @ExcelProperty(value = "备注", index = 6)
    public String last;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSax() {
        return sax;
    }

    public void setSax(String sax) {
        this.sax = sax;
    }

    public String getHeigh() {
        return heigh;
    }

    public void setHeigh(String heigh) {
        this.heigh = heigh;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
