package com.coderscampus.olaf.assignment14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.olaf.assignment14.domain.Channel;
import com.coderscampus.olaf.assignment14.domain.ChatMessage;
import com.coderscampus.olaf.assignment14.repository.ChannelRepository;

@Service
public class ChannelService {

	@Autowired
	private ChannelRepository channelRepo;

	public List<Channel> getAllChannels() {
		
		return channelRepo.getAllChannels();
	}

	public Channel findById(Long channelId) {
		return channelRepo.findById(channelId);
	}

	public void saveMessageToChannel(ChatMessage message) {
		Channel currentChannel = findById(message.getChannelId());
		channelRepo.saveMessageToChannel(currentChannel, message);
		
	}

	public Channel allMessages(Channel channelId) {
		Long id = channelId.getId();
		return findById(id);
	}

}
