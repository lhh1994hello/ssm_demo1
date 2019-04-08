package com.atguigu.demo.transaction.help;

import com.atguigu.demo.transaction.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: lhh
 * @Date: 2019/4/8 22:15
 * @Version 1.0
 * 一个人购买多本书
 */
@Service(value = "cashier")
public class CashierImpl implements Cashier {
    @Autowired
    private BookShopService bookShopService;

    /**
     * 一个事物方法要去调用另外一个事物方法
     */
    @Transactional
    @Override
    public void checout(String username, List<String> isbns) {
        for (String isbn : isbns) {
            bookShopService.purchase(username, isbn);
        }
    }
}
