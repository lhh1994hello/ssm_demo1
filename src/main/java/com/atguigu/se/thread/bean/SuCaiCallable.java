package com.atguigu.se.thread.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * @Author: lhh
 * @Date: 2019/4/15 23:50
 * @Version 1.0
 */
public class SuCaiCallable implements Callable<Boolean> {
    private static final Logger logger = LoggerFactory.getLogger(SuCaiCallable.class);

    @Override
    public Boolean call() throws Exception {
        try {
            System.out.println("开始买素材...");
            Thread.sleep(3000);
            System.out.println("买好素材了...");
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
    }
}
