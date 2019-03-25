package com.atguigu.demo.spring.help;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author lhh
 * @date 2019/3/24 20:49
 * @Description:
 */
public class MyBeanProcesser implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("前-postProcessBeforeInitialization:" + bean + "," + beanName+",,,..................");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("后-postProcessAfterInitialization:" + bean + "," + beanName+",,,.....................");
        return bean;
    }
}
