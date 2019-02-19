package com.atguigu.crud.websocket;

@SuppressWarnings("all")
public class WebSocketMsg {

	private String from;
	private String content;
	private String date;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public WebSocketMsg() {
		super();
		// TODO Auto-generated constructor stub
	}

}
