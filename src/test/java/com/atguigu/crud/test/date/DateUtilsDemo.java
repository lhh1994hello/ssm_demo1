package com.atguigu.crud.test.date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lhh
 * @date 2019/4/11 9:23
 * @Description: 测试时间
 */
public class DateUtilsDemo {
    @Test
    public void fun1() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = DateUtils.addDays(new Date(), 1);
        String format = sdf.format(date);
        System.out.println(format);
    }
}
