package com.atguigu.demo.transaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author lhh
 * @date 2019/4/8 12:58
 * @Description:
 */
public class TxDemo {
    ApplicationContext context = new ClassPathXmlApplicationContext("config/transaction/applicationContext-transaction.xml");

    @Test
    public void fun1() throws SQLException {
        DataSource dataSource = context.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        BookShopDao bookShopDao = context.getBean(BookShopDao.class);
        int price = bookShopDao.findBookPriceByIsbn("1001");
        System.out.println("价格:" + price);


    }
}
