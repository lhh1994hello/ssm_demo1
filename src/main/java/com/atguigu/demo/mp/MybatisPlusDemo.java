package com.atguigu.demo.mp;

import com.atguigu.common.mp.bean.TblEmployee;
import com.atguigu.common.mp.mapper.TblEmployeeMapper;
import com.atguigu.crud.bean.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;

/**
 * @author lhh
 * @date 2019/4/2 10:30
 * @Description:
 */
public class MybatisPlusDemo {
    private ApplicationContext context = new ClassPathXmlApplicationContext("config/mp/applicationContext-mybatisplus.xml");
    private TblEmployeeMapper employeeMapper = context.getBean("tblEmployeeMapper", TblEmployeeMapper.class);


    /**
     * 测试连接
     *
     * @throws SQLException
     */
    @Test
    public void fun1() throws SQLException {

        DataSource dataSource = context.getBean("pooledDataSource", DataSource.class);
        System.out.println("测试:" + dataSource);
        Connection connection = dataSource.getConnection();
        System.out.println("连接:" + connection);
    }

    /**
     * 测试插入数据
     */
    @Test
    public void fun2() {
        Random random = new Random();
        int randomNum = random.nextInt(10);

        TblEmployee employee = new TblEmployee("张三_" + randomNum, "zhangsan@qq.com" + randomNum, 1, 22);
        Integer insert = employeeMapper.insert(employee);
        System.out.println("插入:" + insert);
    }


}
