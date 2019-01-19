package com.atguigu.crud.config;

import java.util.HashSet;
import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//作者:lhh 创建时间:2019年1月18日 下午9:04:02 
public class WebsocketConfig implements ServerApplicationConfig {
	private final Logger logger = LoggerFactory.getLogger(WebsocketConfig.class);

	// 注解方式的启动
	@Override
	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scand) {
		logger.info("WebsocketConfig配置类...................,长度:{}", scand.size());
		System.out.println("WebsocketConfig配置类.............长度:" + scand.size());
		Set<Class<?>> results = new HashSet<>();
		//提供了一定的过滤作用
		for (Class<?> clazz : scand) {
			if (clazz.getPackage().getName().startsWith("websocket.")) {
				results.add(clazz);
			}
		}
		return scand;
	}

	// 接口方式启动
	@Override
	public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
