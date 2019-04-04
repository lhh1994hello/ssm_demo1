package com.atguigu.se.design.proxy.demo1;

import org.junit.Test;

/**
 * @author lhh
 * @date 2019/4/4 9:39
 * @Description:
 */
public class BookdinnerDemo {
    @Test
    public void fun1() {
        Bookdinner bookdinner = new BookdinnerImpl();
        Bookdinner proxy =
                new BookdinnerProxy(bookdinner).getBookDinnerProxy();
        double pay = proxy.pay(58.60);
        System.out.println("-------------------------------");
        String s = proxy.orderBook("麻辣香锅", "银月湾");
    }
}
