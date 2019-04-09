package com.atguigu.se.db;

import org.junit.Test;
import org.springframework.util.StopWatch;

import java.sql.*;
import java.util.Random;

/**
 * @author lhh
 * @date 2019/4/9 8:57
 * @Description: 原生方式连接数据库
 */
public class MysqlJDBCDDemo {
    //rewriteBatchedStatements=true是批处理开关，设置为true才行
    private static final String URL = "jdbc:mysql://106.14.155.20:3306/ssm_crud?characterEncoding=utf-8&rewriteBatchedStatements=true";
    private static final String DRIVERCLASS = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    //循环数量
    private static final int EXECUTENUMBER = 50;

    //获取数据库连接测试
    @Test
    public void MysqlConnectDB() {
        try {
            Class.forName(DRIVERCLASS);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("连接:" + connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //验证数据库普通插入和预编译插入，批处理插入的效率
    @Test
    public void jdbcPrepareDemo() throws SQLException, ClassNotFoundException {
        StopWatch stopWatch = new StopWatch("插入测试...");
        Class.forName(DRIVERCLASS);
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("连接:" + connection);
        stopWatch.start("预编译类型");
        executePrepareSQL(connection);
        stopWatch.stop();
        stopWatch.start("非预编译类型");
        executeNativeSQL(connection);
        stopWatch.stop();

        stopWatch.start("批处理类型");
        executeBatchSQL(connection);
        stopWatch.stop();


        System.out.println(stopWatch.prettyPrint());
        System.out.println(stopWatch.shortSummary());
    }

    //预编译sql
    public void executePrepareSQL(Connection connection) throws SQLException {
        Random random = new Random();
        int randomNum = 0;
        int successNumber = 0;
        String sql = "INSERT INTO tbl_book(author,book_name,price) VALUES (?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        for (int i = 0; i < EXECUTENUMBER; i++) {
            randomNum = random.nextInt(100);
            pstm.setString(1, "张胜男_" + randomNum);
            pstm.setString(2, "java_" + randomNum);
            pstm.setDouble(3, 100);
            int updateNum = pstm.executeUpdate();
            successNumber++;
        }
        System.out.println("预编译成功记录数:" + successNumber);
    }

    //不预编译sql
    public void executeNativeSQL(Connection connection) throws SQLException {
        Random random = new Random();
        int randomNum = 0;
        for (int i = 0; i < EXECUTENUMBER; i++) {
            randomNum = random.nextInt(100);
            String sql = "INSERT INTO tbl_book(author,book_name,price) VALUES " +
                    "(" + "'" + "张三_" + randomNum + "'" + ",'java_" + randomNum + "'" + "," + 200 + ")";
            Statement statement = connection.createStatement();
            boolean execute = statement.execute(sql);
        }
        System.out.println("非预编译执行完毕...");
    }

    //执行批处理sql
    public void executeBatchSQL(Connection connection) throws SQLException {
        Random random = new Random();
        int randomNum = 0;
        String sql = "INSERT INTO tbl_book(author,book_name,price) VALUES (?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        // 使用循环疯狂添加参数
        for (int i = 0; i < EXECUTENUMBER; i++) {
            randomNum = random.nextInt(100);
            pstm.setString(1, "批_张胜男_" + randomNum);
            pstm.setString(2, "批_数据结构_" + randomNum);
            pstm.setDouble(3, 300);
            // 添加批, 这一组参数就保存到集合中.
            pstm.addBatch();
        }
        // 执行批方法, 向数据库发送 sql 语句
        pstm.executeBatch();
        System.out.println("批处理执行完毕...");
    }

    //原生查询方法
    @Test
    public void queryDBDemo() throws SQLException {
        Connection connection = MysqlDBUtil.getConnection();
        String sql = "SELECT * FROM tbl_book WHERE id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        // pstm.setInt(1, 6750);
        pstm.setString(1, "6750 or 1=1");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String author = rs.getString("author");
            String bookName = rs.getString("book_name");
            double price = rs.getDouble("price");
            System.out.println("主键:" + id + ",作者:" + author + ",bookName:" + bookName + ",price:" + price);
        }
        connection.close();
        pstm.close();
    }

    //不使用预编译查询，可以进行sql注入
    @Test
    public void queryDBDemo2() throws SQLException {
        Connection connection = MysqlDBUtil.getConnection();
        String sql = "SELECT * FROM tbl_book WHERE id= 6750 or 1=1";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            String author = rs.getString("author");
            String bookName = rs.getString("book_name");
            double price = rs.getDouble("price");
            System.out.println("主键:" + id + ",作者:" + author + ",bookName:" + bookName + ",price:" + price);
        }
        connection.close();
    }
}
