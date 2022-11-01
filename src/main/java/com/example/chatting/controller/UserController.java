package com.example.chatting.controller;

import com.example.chatting.model.User;
import com.example.chatting.model.dto.UserDTO;
import com.example.chatting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin
	public ResponseEntity<User> createStaff(@RequestBody UserDTO staffDAO){
		return new ResponseEntity<>(userService.createUser(staffDAO), HttpStatus.OK);
	}
}
