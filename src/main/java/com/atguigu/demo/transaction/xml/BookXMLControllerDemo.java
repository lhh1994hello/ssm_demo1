package com.atguigu.demo.transaction.xml;

import com.atguigu.demo.transaction.anno.service.BookShopService;
import com.atguigu.demo.transaction.anno.help.Cashier;
import com.atguigu.demo.transaction.xml.help.CashierXML;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @Author: lhh
 * @Date: 2019/4/8 22:00
 * @Version 1.0
 */
public class BookXMLControllerDemo {
    ApplicationContext context = new ClassPathXmlApplicationContext("config/transaction/applicationContext-transaction-xml.xml");

    @Test
    public void fun1() {
        BookShopService bookShopService = context.getBean(BookShopService.class);
        bookShopService.purchase("AA", "1001");
    }

    /**
     * 测试事物的传播行为
     */
    @Test
    public void testTransactionPropagation() {
        CashierXML cashierXML = context.getBean(CashierXML.class);
        cashierXML.checout("AA", Arrays.asList("1001", "1002"));
    }
}


