package com.coderscampus.olaf.assignment14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.olaf.assignment14.domain.Channel;
import com.coderscampus.olaf.assignment14.domain.ChatMessage;
import com.coderscampus.olaf.assignment14.service.ChannelService;

@RestController
@RequestMapping("/channels")
public class ChannelController {
	
	@Autowired
	ChannelService channelService;

	@PostMapping("/allMessages")
	public Channel getMessages(@RequestBody Channel channelId) {
		return channelService.allMessages(channelId);
	}
	
	@PostMapping("/postMessage")
	public void postMessage (@RequestBody ChatMessage message) {
		channelService.saveMessageToChannel(message);
	}
			
}
