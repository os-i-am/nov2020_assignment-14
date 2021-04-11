package com.coderscampus.olaf.assignment14.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.coderscampus.olaf.assignment14.domain.User;

@Repository
public class UserRepository {

	private List<User> users = new ArrayList<>();

	public User createUser(User user) {
		users.add(user);
		System.out.println(user);
		return user;
		
	}

	public User findLatestUser() {
		if (users.size() > 0) 
			return users.get(users.size() - 1);
		else return null;
	}
}
