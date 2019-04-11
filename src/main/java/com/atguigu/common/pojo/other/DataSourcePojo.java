package com.atguigu.common.pojo.other;

import java.util.Properties;

/**
 * @author lhh
 * @date 2019/3/24 10:58
 * @Description: 测试模拟连接数据库
 */
public class DataSourcePojo {
    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "DataSourcePojo{" +
                "properties=" + properties +
                '}';
    }
}
