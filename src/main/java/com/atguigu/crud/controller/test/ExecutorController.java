package com.atguigu.crud.controller.test;

import com.atguigu.crud.util.Msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lhh
 * @date 2019/4/15 10:54
 * @Description:
 */
@RestController
@RequestMapping("/executor")
public class ExecutorController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/executorPoolDemo")
    public Msg executorPoolDemo() {
        logger.info("线程池使用");
        return Msg.Success();
    }
}
