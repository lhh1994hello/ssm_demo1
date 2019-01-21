package com.atguigu.crud.websocket;

import java.io.IOException;
import java.util.*;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

//作者:lhh 创建时间:2019年1月19日 下午5:11:20 

/**
 * 聊天室
 *
 * @author lhh
 */
@ServerEndpoint("/chatroom")
public class ChatroomSocket {

    private static final Logger logger = LoggerFactory.getLogger(ChatroomSocket.class);
    private static Set<ChatroomSocket> ss = new HashSet<ChatroomSocket>();
    // 保存在线用户列表
    private static List<String> nickNamesList = new ArrayList<String>();
    private String nickName;// 昵称
    private Session pubsession;

    public ChatroomSocket() {
        logger.info("创建了一个ChatroomSocket");
    }

    @OnOpen
    public void open(Session session) {
        logger.info("建立了一个 webSocket通道! sid:{}", session.getId());
        String queryString = session.getQueryString();
        nickName = queryString.substring(queryString.indexOf("=") + 1);
        if (StringUtils.isBlank(queryString)) {
            nickName = session.getId() + "";
        }
        this.pubsession = session;
        ss.add(this);// 将当前对象加入到集合中
        nickNamesList.add(nickName);// 在线列表

        WebSocketLogin login = new WebSocketLogin();
        login.setWelcome(nickName + "进入聊天室！！");
        login.setNickNames(nickNamesList);
        String msg = JSON.toJSONString(login);
        broadcast(ss, msg);
    }

    @OnMessage
    public void message(Session session, String msg) {
        logger.info("客服端来消息啦! sid:{}", session.getId());
        logger.info("消息:" + msg);
        //session.getBasicRemote().sendText("来自服务器:" + msg);
        WebSocketMsg webSocketMsg = new WebSocketMsg();
        webSocketMsg.setContent(msg);
        webSocketMsg.setFrom(nickName);
        webSocketMsg.setDate(new Date().toLocaleString());
        String jsonString = JSON.toJSONString(webSocketMsg);
        broadcast(ss, jsonString);
    }

    @OnClose
    public void close(Session session) {
        logger.info("关闭连接啦! sid:{}", session.getId());
        ss.remove(this);// 从集合中移除
        nickNamesList.remove(nickName);
        WebSocketLogin login = new WebSocketLogin();
        login.setWelcome(nickName + "退出聊天室！！");
        login.setNickNames(nickNamesList);
        String msg = JSON.toJSONString(login);
        broadcast(ss, msg);
    }

//	@OnError
//	public void error() {
//		 
//	}

    // 广播消息
    private void broadcast(Set<ChatroomSocket> ss, String msg) {
        for (Iterator iterator = ss.iterator(); iterator.hasNext(); ) {
           // System.out.println("集合长度:" + ss.size());
            ChatroomSocket chatSocket = (ChatroomSocket) iterator.next();
            try {
                chatSocket.pubsession.getBasicRemote().sendText(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
