package com.kevinduran.parcial2.services.implementatios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevinduran.parcial2.models.entities.User;
import com.kevinduran.parcial2.repositories.UserRepository;
import com.kevinduran.parcial2.services.UserService;

@Service
public class UserImpl implements UserService {

	@Autowired
	private UserRepository userRepository;




	@Override
	public List<User> findall() {
		
		return userRepository.findAll();
	}



	@Override
	public User register(User user) {
		 return userRepository.save(user);
	}



	  @Override
	    public User getUserByUsername(String username) {
	        return userRepository.findByUsernameOrEmail(username, username);
	    }

	

}
