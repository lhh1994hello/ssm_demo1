package com.atguigu.demo.transaction.help;

import java.util.List;

/**
 * @Author: lhh
 * @Date: 2019/4/8 22:13
 * @Version 1.0
 */
public interface Cashier {
    public void checout(String username, List<String> isbns);
}
