package com.atguigu.crud.util.sms;

import com.aliyuncs.exceptions.ClientException;
import com.atguigu.util.SMSUtil;
import org.junit.Test;

/**
 * @author lhh
 * @date 2019/4/3 16:02
 * @Description:
 */
public class SmsDemo {
    @Test
    public void fun1() {
        String phone = "15926154855";
        try {
            String sendPhoneCode = SMSUtil.sendPhoneCode(phone);
            System.out.println(sendPhoneCode);
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
