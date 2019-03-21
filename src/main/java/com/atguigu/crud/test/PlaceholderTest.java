package com.atguigu.crud.test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.MessageFormat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//作者:lhh 创建时间:2019年2月19日 上午10:23:28 
/**
 * 测试占位符
 * 
 * @author lhh
 *
 */
@SuppressWarnings("all")
public class PlaceholderTest {
	private final Logger logger = LoggerFactory.getLogger(PlaceholderTest.class);

	//@Test
	public void fun1() throws UnknownHostException {
		String content = "http://{0}:8088/ssm_demo1/active?uActivaecode={1}";
		InetAddress myip = null;
		myip = InetAddress.getLocalHost();
		System.out.println("你的IP地址是：" + myip.getHostAddress());
		content = MessageFormat.format(content, myip.getHostAddress(), "123456");
		System.out.println("content:" + content);
	}

}
