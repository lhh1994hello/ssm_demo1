package com.atguigu.se.design.proxy.demo1;

/**
 * @author lhh
 * @date 2019/4/4 9:09
 * 订餐接口
 */
public interface Bookdinner {

    public String orderBook(String name, String address);

    public double pay(double money);
}
