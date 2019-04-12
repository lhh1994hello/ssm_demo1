package com.atguigu.common.anno.demo;

import com.atguigu.common.anno.help.AnnoUser;
import com.atguigu.common.anno.help.UserValidateParser;
import org.junit.Test;

/**
 * @author lhh
 * @date 2019/4/12 11:52
 * @Description:
 */
public class AnnoDemo {
    @Test
    public void fun1() {
        AnnoUser user = new AnnoUser();
        user.setName("liang");
        user.setAge("1");

        System.out.println(UserValidateParser.check(user));
    }
}
