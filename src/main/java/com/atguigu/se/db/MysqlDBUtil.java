package com.atguigu.se.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author lhh
 * @date 2019/4/9 10:10
 * @Description:
 */
public class MysqlDBUtil {
    private static final String URL = "jdbc:mysql://106.14.155.20:3306/ssm_crud?characterEncoding=utf-8&rewriteBatchedStatements=true";
    private static final String DRIVERCLASS = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() {

        try {
            //会执行Driver类中的静态代码块
            Class.forName(DRIVERCLASS);
            //DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return connection;
        } catch (Exception e) {
            System.out.println("获取数据库连接失败...");
            e.printStackTrace();
            return null;
        }
    }
}

