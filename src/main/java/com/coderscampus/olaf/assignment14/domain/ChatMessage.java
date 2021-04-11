package com.coderscampus.olaf.assignment14.domain;

public class ChatMessage {
	
	private Long channelId;
	private String username;
	private String message;
	
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ChatMessage [channelId=" + channelId + ", username=" + username + ", message=" + message + "]";
	}
	
	
}
