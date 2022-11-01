package com.example.chatting.service;

import com.example.chatting.model.User;
import com.example.chatting.model.dto.UserDTO;
import com.example.chatting.repository.UserRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepositori userRepositori;

	public User createUser(UserDTO userDTO){
		User user = new User();
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		return userRepositori.save(user);
	}
}
