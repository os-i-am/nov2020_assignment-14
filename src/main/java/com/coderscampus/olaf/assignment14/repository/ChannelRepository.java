package com.coderscampus.olaf.assignment14.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coderscampus.olaf.assignment14.domain.Channel;
import com.coderscampus.olaf.assignment14.domain.ChatMessage;

@Repository
public class ChannelRepository {
	
	private List<Channel> channels = new ArrayList<>();

	public List<Channel> getAllChannels() {
		if (channels.isEmpty())
			initializeGeneralChannel();
		return channels;
	}
	
	public List<Channel> initializeGeneralChannel() {
		channels.add(new Channel(1L, "General"));
		return channels;
	}
	
	public Channel findById(Long channelId) {
		for (Channel channel : channels) {
			if (channel.getId().equals(channelId))
				return channel;
		} 
		return null;
	}

	public void saveMessageToChannel(Channel currentChannel, ChatMessage message) {
		currentChannel.getMessages().add(message);
		System.out.println(currentChannel);
	}

}
