package com.atguigu.demo.transaction.anno.service;

import com.atguigu.demo.transaction.anno.book.BookShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: lhh
 * @Date: 2019/4/8 21:56
 * @Version 1.0
 */
@Service(value = "bookShopService")

public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;
    /**
     * 添加事物注解
     * 1.使用propagation 指定事物的传播行为，即当前的事物方法被另外一个事物方法调用时，
     * 如何使用事物，默认取值为REQUIRED，即使用调用方法的事物
     * 取值为REQUIRES_NEW，新开启一个事物，调用方的事物先挂起
     * 2.事物的隔离级别
     * 使用isolation，指定事物个隔离级别，最常用的是READ_COMMITTED(读已提交,避免脏读)
     * 3.默认情况下spring的声明式事物对所有的运行时异常进行回滚，
     * 也可以通过对应的属性进行设置,noRollbackFor对哪些异常不进行回滚(即还是提交)
     * 4.使用readOnly指定事物是否是只读属性，设置为只读，表示这个事物只读数据，但不更新数据
     * 这样可以帮助数据库引擎优化事物
     * 5.timeout:当方法运行时间超过时间后，就会回滚，单位:秒
     */
    //@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED, noRollbackFor = {UserAccountException.class})
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED, timeout = 5)
    @Override
    public void purchase(String username, String isbn) {
        int price = bookShopDao.findBookPriceByIsbn(isbn); //1.获取书的单价
        bookShopDao.updateBookStock(isbn);  //2.更新书的库存
        bookShopDao.updateUserAccount(username, price);  //3.更新用户余额
    }
}
