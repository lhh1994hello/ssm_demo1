package com.atguigu.se.design.proxy.demo1;

/**
 * @author lhh
 * @date 2019/4/4 9:23
 * @Description:
 */
public class BookdinnerImpl implements Bookdinner {
    @Override
    public String orderBook(String name, String address) {
        System.out.println("商品名称:" + name + "送餐地址:" + address);
        return "商品名称:" + name + "送餐地址:" + address;
    }

    @Override
    public double pay(double money) {
        System.out.println("付款金额:" + money);
        return money;
    }
}
