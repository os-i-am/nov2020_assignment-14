package com.coderscampus.olaf.assignment14.domain;

import java.util.ArrayList;
import java.util.List;

public class Channel {

	private Long id;
	private String channelName;
	private List<ChatMessage> messages = new ArrayList<>();

	public Channel(long id, String channelName) {
		this.setId(id);
		this.setChannelName(channelName);
	}

	public Channel() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public List<ChatMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<ChatMessage> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "Channel [id=" + id + ", channelName=" + channelName + ", messages=" + messages + "]";
	}
	
	

}
