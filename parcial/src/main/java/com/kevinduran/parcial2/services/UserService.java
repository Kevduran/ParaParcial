package com.kevinduran.parcial2.services;

import java.util.List;

import com.kevinduran.parcial2.models.entities.User;


public interface UserService {
	
	List<User> findall();
	 User getUserByUsername(String username);
	User register(User user);
	
}
