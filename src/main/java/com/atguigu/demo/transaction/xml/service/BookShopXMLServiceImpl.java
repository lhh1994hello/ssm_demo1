package com.atguigu.demo.transaction.xml.service;

import com.atguigu.demo.transaction.xml.book.BookShopXMLDao;

/**
 * @author lhh
 * @date 2019/4/10 15:10
 * @Description:
 */
public class BookShopXMLServiceImpl implements BookShopXMLService {

    private BookShopXMLDao bookShopXMLDao;

    public void setBookShopXMLDao(BookShopXMLDao bookShopXMLDao) {
        this.bookShopXMLDao = bookShopXMLDao;
    }

    @Override
    public void purchase(String username, String isbn) {
        int price = bookShopXMLDao.findBookPriceByIsbn(isbn); //1.获取书的单价
        bookShopXMLDao.updateBookStock(isbn);  //2.更新书的库存
        bookShopXMLDao.updateUserAccount(username, price);  //3.更新用户余额
    }
}
