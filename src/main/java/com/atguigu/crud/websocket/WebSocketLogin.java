package com.atguigu.crud.websocket;

 

import java.util.List;

public class WebSocketLogin {

	private  String  welcome;
	
	private List<String>  nickNames;
	
	public List<String> getNickNames() {
		return nickNames;
	}
	public void setNickNames(List<String> nickNames) {
		this.nickNames = nickNames;
	}
	public String getWelcome() {
		return welcome;
	}
	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}
	public WebSocketLogin() {
		super();
	}
	
	
}
