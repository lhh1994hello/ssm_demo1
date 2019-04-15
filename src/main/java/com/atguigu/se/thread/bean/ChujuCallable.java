package com.atguigu.se.thread.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * @Author: lhh
 * @Date: 2019/4/15 23:45
 * @Version 1.0
 * 测试Future类，买厨具
 */
public class ChujuCallable implements Callable<Boolean> {
    private static final Logger logger = LoggerFactory.getLogger(ChujuCallable.class);

    @Override
    public Boolean call() throws Exception {
        try {
            System.out.println("开始买厨具###");
            Thread.sleep(3000);
            System.out.println("买好厨具了###");
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
    }
}
