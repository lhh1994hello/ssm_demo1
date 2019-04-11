package com.atguigu.crud.test.test1;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//作者:lhh 创建时间:2019年3月11日 上午10:44:55 
public class RegexTest {
    /**
     * 测试输入的金额是否合法
     */
    @Test
    public void moneyDemo() {
        String moneyRegex = "(^[1-9]([0-9]+)?(\\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\\.[0-9]([0-9])?$)";
        String moneyAccount = "1.22";
        if (moneyAccount.matches(moneyRegex)) {
            System.out.println("匹配");
        } else {
            System.out.println("不匹配");
        }
        BigDecimal bigDecimal = new BigDecimal(moneyAccount);
        System.out.println("结果:" + bigDecimal);
    }

    @Test
    public void RegexPhoneDemo() {
        String phone = "13123456789";
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        if (phone.length() != 11) {
            System.out.println("手机号应为11位数");
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();
            if (isMatch) {
                System.out.println("您的手机号" + phone + "是正确格式@——@");
            } else {
                System.out.println("您的手机号" + phone + "是错误格式！！！");
            }
        }
    }
}
