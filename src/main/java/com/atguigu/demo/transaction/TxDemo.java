package com.atguigu.demo.transaction;

import com.atguigu.demo.transaction.book.BookShopDao;
import com.atguigu.demo.transaction.help.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

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

    //测试扣库存方法
    @Test
    public void updateBookStockTest() {
        BookShopDao bookShopDao = context.getBean(BookShopDao.class);
        bookShopDao.updateBookStock("1001");
    }

    //测试扣余额方法
    @Test
    public void updateUserAccountTest() {
        BookShopDao bookShopDao = context.getBean(BookShopDao.class);
        bookShopDao.updateUserAccount("AA", 59);
    }

    /**
     * 测试事物的传播行为
     */
    @Test
    public void testTransactionPropagation() {
        Cashier cashier = context.getBean(Cashier.class);
        cashier.checout("AA", Arrays.asList("1001", "1002"));
    }
}
