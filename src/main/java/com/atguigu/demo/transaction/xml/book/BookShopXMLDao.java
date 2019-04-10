package com.atguigu.demo.transaction.xml.book;

/**
 * @author lhh
 * @date 2019/4/10 15:07
 */
public interface BookShopXMLDao {
    //根据书号获取书的单价
    public int findBookPriceByIsbn(String isbn);

    //更新书的库存，使书号对应的库存减1
    public void updateBookStock(String isbn);

    //更新账户余额，使username的balance-price
    public void updateUserAccount(String username, int price);
}
