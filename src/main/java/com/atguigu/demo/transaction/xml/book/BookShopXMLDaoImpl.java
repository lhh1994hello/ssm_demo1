package com.atguigu.demo.transaction.xml.book;

import com.atguigu.demo.transaction.exception.BookStockException;
import com.atguigu.demo.transaction.exception.UserAccountException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author lhh
 * @date 2019/4/10 15:08
 * @Description: 使用配置文件配置数据库事务
 */
public class BookShopXMLDaoImpl implements BookShopXMLDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //根据书号获得书的价格
    @Override
    public int findBookPriceByIsbn(String isbn) {
        String sql = "SELECT price FROM tx_book WHERE isbn=?";
        //第二个参数指定返回值类型
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
        return price;
    }

    //扣库存
    @Override
    public void updateBookStock(String isbn) {
        //检查书的库存是否足够
        String sql2 = " SELECT stock FROM tx_book_stock where isbn=?";
        Integer stock = jdbcTemplate.queryForObject(sql2, Integer.class, isbn);
        if (stock == 0) {
            throw new BookStockException("库存不足...");
        }
        String sql = " UPDATE tx_book_stock set stock=stock-1 WHERE isbn= ?";
        jdbcTemplate.update(sql, isbn);
    }

    //扣款
    @Override
    public void updateUserAccount(String username, int price) {
        String sql2 = " SELECT balance FROM tx_account where username=?";
        Integer balance = jdbcTemplate.queryForObject(sql2, Integer.class, username);
        if (balance < price) {
            throw new UserAccountException("余额不足...");
        }
        String sql = "UPDATE tx_account SET balance=balance-? WHERE username= ?";
        jdbcTemplate.update(sql, price, username);
    }
}
