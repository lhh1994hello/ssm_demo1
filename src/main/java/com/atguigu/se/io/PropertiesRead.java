package com.atguigu.se.io;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author lhh
 * @date 2019/3/24 11:14
 * @Description: 读取properties配置文件中的值
 */
public class PropertiesRead {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesRead.class);

    public static void main(String[] args) {

    }

    @Test
    public void fun1() throws IOException {
        Properties props = new Properties();
        //InputStream input = this.getClass().getClassLoader().getResourceAsStream("config/merchantInfo.properties");
        InputStream input = this.getClass().getClassLoader().getResourceAsStream("dbconfig.properties");
        props.load(input);
        String url = props.getProperty("jdbc.jdbcUrl");
        String driverClass = props.getProperty("jdbc.driverClass");
        String user = props.getProperty("jdbc.user");
        String password = props.getProperty("jdbc.password");
        logger.info("url:{},driver:{},user:{},password:{}", url, driverClass, url, password);
    }
}
