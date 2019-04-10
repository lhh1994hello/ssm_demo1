package com.atguigu.demo.transaction.xml.help;

import com.atguigu.demo.transaction.xml.service.BookShopXMLService;

import java.util.List;

/**
 * @author lhh
 * @date 2019/4/10 15:29
 * @Description:
 */
public class CashierXMLImpl implements CashierXML {

    private BookShopXMLService bookShopXMLService;

    public void setBookShopXMLService(BookShopXMLService bookShopXMLService) {
        this.bookShopXMLService = bookShopXMLService;
    }

    @Override
    public void checout(String username, List<String> isbns) {
        for (String isbn : isbns) {
            bookShopXMLService.purchase(username, isbn);
        }
    }
}
