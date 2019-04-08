package com.atguigu.demo.spring.help;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author lhh
 * @date 2019/3/24 20:49
 * @Description: ①Spring中的后置处理器BeanPostProcessor讲解
 * ②如果我们想在Spring容器中完成bean实例化、配置以及其他初始化方法前后要添加一些自己逻辑处理。
 * 我们需要定义一个或多个BeanPostProcessor接口实现类，然后注册到Spring IoC容器中。
 */
public class MyBeanProcesser implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("前-postProcessBeforeInitialization:" + bean + "," + beanName + ",,,..................");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("后-postProcessAfterInitialization:" + bean + "," + beanName + ",,,.....................");
        return bean;
    }
}
