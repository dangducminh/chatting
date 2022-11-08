package com.example.chatting.controller;

import com.example.chatting.model.RequestLogin;
import com.example.chatting.model.User;
import com.example.chatting.model.dto.UserDTO;
import com.example.chatting.model.dto.UserInfo;
import com.example.chatting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/register")
	@CrossOrigin
	public ResponseEntity<User> createStaff(@RequestBody UserDTO staffDAO){
		return new ResponseEntity<>(userService.createUser(staffDAO), HttpStatus.OK);
	}

	@PostMapping(value = "/login")
	@CrossOrigin
	public ResponseEntity<User> login(@RequestBody RequestLogin requestLogin){
		return new ResponseEntity<>(userService.login(requestLogin.getEmail(),requestLogin.getPassword()), HttpStatus.OK);
	}

	@PostMapping(value = "/info")
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<UserInfo> showInfo(@RequestParam(name = "uid") String uid){
		return new ResponseEntity<>(userService.getInfo(Long.parseLong(uid)), HttpStatus.OK);
	}

	@PostMapping(value = "/search_friend")
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<List<UserInfo>> findUserByWord(@RequestParam(name = "word") String word){
		return new ResponseEntity<>(userService.getUserByWordInName(word), HttpStatus.OK);
	}
}
