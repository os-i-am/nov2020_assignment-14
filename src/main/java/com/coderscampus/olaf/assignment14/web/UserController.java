package com.coderscampus.olaf.assignment14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.olaf.assignment14.domain.Channel;
import com.coderscampus.olaf.assignment14.domain.User;
import com.coderscampus.olaf.assignment14.service.ChannelService;
import com.coderscampus.olaf.assignment14.service.UserService;

import org.springframework.ui.ModelMap;

@Controller
public class UserController {

	@Autowired
	private ChannelService channelService;
	@Autowired
	private UserService userService;

	@GetMapping("/welcome")
	public String getAllUsers(ModelMap model) {
		List<Channel> channels = channelService.getAllChannels();
		model.put("channels", channels);
		return "welcome";
	}

	@GetMapping("/channels/{channelId}")
	public String getChannel(ModelMap model, @PathVariable Long channelId) {
		Channel channel = channelService.findById(channelId);
		model.put("channel", channel);
		return "channel";
	}

	@PostMapping("/users/createUser")
	@ResponseBody
	public User createUser(@RequestBody User user) {
		return (userService.createUser(user));
	}

}
