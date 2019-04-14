package com.atguigu.crud.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author: lhh
 * @Date: 2019/4/10 21:28
 * @Version 1.0
 */
public class ApplicationListenerDemo implements ServletContextListener {
    private static Logger logger = LoggerFactory.getLogger(ApplicationListenerDemo.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //System.out.println("自定义监听器类contextInitialized方法...");
        //logger.info("自定义监听器类contextInitialized方法...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //System.out.println("contextDestroyed...");
        //logger.info("自定义监听器类contextDestroyed方法...");
    }
}
