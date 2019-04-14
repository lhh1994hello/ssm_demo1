package com.atguigu.crud.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @Author: lhh
 * @Date: 2019/4/14 10:14
 * @Version 1.0
 * ServletRequestListener：监听request对象的创建和销毁
 * ServletRequestAttributeListener：监听request作用域数据的变更
 */
public class RequestListenerDemo implements ServletRequestListener, ServletRequestAttributeListener {
    private Logger logger = LoggerFactory.getLogger(RequestListenerDemo.class);

    //request对象创建
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        String name = sre.getClass().getName();
        //System.out.println("servletRequest监听器---》被销毁了：" + name);
       // logger.info("servletRequest监听器---》被销毁了:{}", name);
    }

    //request对象销毁
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        String name = sre.getClass().getName();
        //System.out.println("servletRequest监听器---》被创建了：" + name);
       // logger.info("servletRequest监听器---》被创建了:{}", name);
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        String name = srae.getName();
        Object value = srae.getValue();
       // logger.info("servletRequest监听器---》放数据了:{},{}", name, value);
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        String name = srae.getName();
        Object value = srae.getValue();
        //logger.info("servletRequest监听器---》移除数据了:{},{}", name, value);
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        String name = srae.getName();
        Object value = srae.getValue();
       // logger.info("servletRequest监听器---》修改数据了:{},{}", name, value);
    }
}
