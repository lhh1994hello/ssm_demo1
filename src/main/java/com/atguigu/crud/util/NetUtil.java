package com.atguigu.crud.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//作者:lhh 创建时间:2019年2月19日 上午10:17:20 
public class NetUtil {
	private final static Logger logger = LoggerFactory.getLogger(NetUtil.class);

	/**
	 * 获得主机名(ip地址)
	 * 
	 * @return
	 */
	public static String getHostAddress() {
		InetAddress myip = null;
		String hostAddress = null;
		try {
			myip = InetAddress.getLocalHost();
			hostAddress = myip.getHostAddress();
		} catch (UnknownHostException e) {
			logger.error("获取ip地址错误!:{}", e);
			e.printStackTrace();
		}
		return hostAddress;
	}
}
