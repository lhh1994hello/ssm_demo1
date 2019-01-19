package com.atguigu.crud.websocket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//作者:lhh 创建时间:2019年1月18日 下午9:14:11 
/**
 * 没个请求都是一个独立的对象，不会造成多线程冲突
 * 
 * @author lhh
 *
 */
@ServerEndpoint("/echo")
public class EchoSocket {
	private final Logger logger = LoggerFactory.getLogger(EchoSocket.class);

	public EchoSocket() {
		System.out.println("EchoSocket()构造方法...");
	}

	// 只要有人连接这个websocket类，open方法就会执行
	// 一个session代表一个通信会话，
	@OnOpen
	public void open(Session session) {
		logger.info("open连接进来了,{}", session);
		System.out.println("sessionId:" + session.getId());
	}

	// 当浏览器关闭时调用
	@OnClose
	public void close(Session session) {
		logger.info("close-关闭啦:{}", session);
		System.out.println("close-关闭啦:" + session.getId());
	}

	// 接收发送过来的信息
	@OnMessage
	public void message(Session session, String msg) {
		System.out.println("客户端:" + msg);
		try {
			session.getBasicRemote().sendText("来自服务器:"+msg);
		} catch (IOException e) {
			logger.error("message方法错误:{}",e);
			e.printStackTrace();
		}
	}
}
