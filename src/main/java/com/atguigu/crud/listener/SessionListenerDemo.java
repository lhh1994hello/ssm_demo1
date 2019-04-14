package com.atguigu.crud.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Author: lhh
 * @Date: 2019/4/14 10:53
 * @Version 1.0
 */
public class SessionListenerDemo implements HttpSessionListener, HttpSessionAttributeListener {
    private Logger logger = LoggerFactory.getLogger(SessionListenerDemo.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        String name = se.getName();//获取session域的键
        Object value = se.getValue();//获取session域的值
        //logger.info("监听--》session添加:{},{}", name, value);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        String name = se.getName();//获取session域的键
        Object value = se.getValue();//获取session域的值
        //logger.info("监听--》session移除:{},{}", name, value);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        String name = se.getName();//获取session域的键
        Object value = se.getValue();//获取session域的值
        //logger.info("监听--》session替换:{},{}", name, value);
    }
}
