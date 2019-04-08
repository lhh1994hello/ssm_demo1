package com.atguigu.demo.transaction;

import com.atguigu.demo.transaction.service.BookShopService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: lhh
 * @Date: 2019/4/8 22:00
 * @Version 1.0
 */
public class BookControllerDemo {
    ApplicationContext context = new ClassPathXmlApplicationContext("config/transaction/applicationContext-transaction.xml");

    @Test
    public void fun1() {
        BookShopService bookShopService = context.getBean(BookShopService.class);
        bookShopService.purchase("AA", "1001");
    }
}


