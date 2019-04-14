package com.atguigu.crud.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Author: lhh
 * @Date: 2019/4/14 11:09
 * @Version 1.0
 * 统计在线人数
 */
public class StatisticsOnlineCountListener implements HttpSessionListener, ServletContextListener {
    //session创建时，人数自增1
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //获取ServletContext对象
        ServletContext sc = se.getSession().getServletContext();
        //获取在线人数的变量
        int count = (int) sc.getAttribute("count");
        count = count + 1;
        sc.setAttribute("count", count);
    }

    //session销毁时，人数自减1
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext sc = se.getSession().getServletContext();
        //获取在线人数的变量
        int count = (int) sc.getAttribute("count");
        if (count > 0) {
            count = count - 1;
        }
        sc.setAttribute("count", count);
    }

    //application初始化
    //ServletContextListener的方法...
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        //count代表在线人数，初始化为0
        sc.setAttribute("count", 0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
