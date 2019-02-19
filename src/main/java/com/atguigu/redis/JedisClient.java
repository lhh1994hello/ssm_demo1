package com.atguigu.redis;

import org.springframework.stereotype.Component;

import redis.clients.jedis.JedisPool;

//作者:lhh 创建时间:2019年1月23日 下午4:09:12 
/**
 * redis客户端
 * 
 * @author lhh
 *
 */
@Component
@SuppressWarnings("all")
public class JedisClient {
	private static JedisPool jedisPool;

	private static final Integer REDIS_PORT = 6379;
	private static final String REDIS_HOST = "127.0.0.1";
	static {
		jedisPool = new JedisPool(REDIS_HOST, REDIS_PORT);
	}

}
