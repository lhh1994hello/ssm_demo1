package com.atguigu.demo.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author lhh
 * @date 2019/4/8 13:11
 * @Description:
 */
@Repository(value = "BookShopDao")
public class BookShopDaoImpl implements BookShopDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int findBookPriceByIsbn(String isbn) {
        String sql = "SELECT price FROM tx_book WHERE isbn=?";
        //第二个参数指定返回值类型
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
        //String s = jdbcTemplate.queryForObject(sql, String.class, isbn);
        return price;
    }

    @Override
    public void updateBookStock(String isbn) {

    }

    @Override
    public void updateUserAccount(String username, int price) {

    }
}
