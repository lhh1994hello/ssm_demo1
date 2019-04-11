package com.atguigu.crud.test.test1;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Properties;

import com.atguigu.crud.test.pt.TbUser;
import com.atguigu.crud.test.pt.TbUserVO;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

//作者:lhh 创建时间:2018年12月7日 下午2:05:42 
public class SomeDemo {

    @Test
    public void fun1() {
        String input = "1.44335632343E21";
        BigDecimal one = new BigDecimal(input);
        String regx = "^((-?\\d+.?\\d*)[Ee]{1}(-?\\d+))$";// 科学计数法正则表达式
        boolean matches = input.matches(regx);
        System.out.println(matches);
        // BigDecimal one = new BigDecimal(1.44335632343E21);
        System.out.println(one.toPlainString());
    }

    @Test
    public void fun2() throws UnknownHostException {
        String content = "http://{0}:8088/ssm_demo1/active?uActivaecode={1}";
        InetAddress myip = null;
        myip = InetAddress.getLocalHost();
        System.out.println("你的IP地址是：" + myip.getHostAddress());
        content = MessageFormat.format(content, myip.getHostAddress(), "123456");
        System.out.println("content:" + content);
    }

    @Test
    public void fun3() {
        String str = "254468849979Z";
        String s = new BigDecimal(str).toPlainString();
        System.out.println(s);
    }

    @Test
    public void PropertiesDemo() {
        Properties properties = new Properties();
        properties.setProperty("a", "A");
        properties.setProperty("b", "B");
        System.out.println(properties);
    }

    @Test
    public void BeanUtilDemo() {
        TbUser user = new TbUser("张三", "123", "男", new Date());
        TbUserVO userVO = new TbUserVO();
        System.out.println(user);
        System.out.println(userVO);
        System.out.println("======================");
        BeanUtils.copyProperties(user, userVO);
        System.out.println(userVO);
    }
}
