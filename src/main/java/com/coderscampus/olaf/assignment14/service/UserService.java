package com.coderscampus.olaf.assignment14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.olaf.assignment14.domain.User;
import com.coderscampus.olaf.assignment14.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	private Long userId = 0L;

	public User createUser(User user) {
		user.setId(userId++);
		return userRepo.createUser(user);
		
	}

	public User findLatestUser() {
		return userRepo.findLatestUser();
	}

}
