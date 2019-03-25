package com.atguigu.common.pojo.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lhh
 * @date 2019/3/24 21:32
 * @Description: 静态工厂方法，直接调用一个类的静态方法就可以返回bean的实例
 */
public class StaticCarFactory {
    private static Map<String, FactoryDemo> factoryDemos = new HashMap<String, FactoryDemo>();

    static {
        factoryDemos.put("audi", new FactoryDemo("奥迪", 30000));
        factoryDemos.put("ford", new FactoryDemo("福特", 40000));
    }

    //根据品牌返回对应的实例
    public static FactoryDemo getFactoryDemo(String name) {
        return factoryDemos.get(name);
    }
}
