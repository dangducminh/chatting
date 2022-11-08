package com.example.chatting.service;

import com.example.chatting.model.User;
import com.example.chatting.model.dto.UserDTO;
import com.example.chatting.model.dto.UserInfo;
import com.example.chatting.repository.UserRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	@Autowired
	private UserRepositori userRepositori;

	@Transactional
	public User createUser(UserDTO userDTO){
		User user = new User();
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		User a = userRepositori.save(user);
		return a;
	}

	public UserInfo getInfo(Long uid){
		UserInfo userInfo = new UserInfo();
		Optional<User> user = userRepositori.findById(uid);
		if (user.isPresent()){
			userInfo.setName(user.get().getName());
			userInfo.setEmail(user.get().getEmail());
		}
		return userInfo;
	}

	public User login(String email, String password) {
		return userRepositori.findAllByEmailAndPassword(email,password);
	}

	public List<UserInfo> getUserByWordInName(String word) {
		List<User> userList = userRepositori.findByNameContaining(word);
		List<UserInfo> result = new ArrayList<>();
		if (!userList.isEmpty()){
			for (User user:userList) {
				result.add(new UserInfo(user.getName(), user.getEmail()));
			}
		}
		return result;
	}
}
