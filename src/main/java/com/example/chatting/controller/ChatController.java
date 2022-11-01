package com.example.chatting.controller;

import com.example.chatting.model.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class ChatController {

	List<ChatMessage> chatMessages = new ArrayList<>();

	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		chatMessages.add(chatMessage);
		chatMessages.stream().forEach(temp->log.info(temp.toString()));
		log.info("--------------------------");
		return chatMessage;
	}

	@MessageMapping("/chat.addUser")
	@SendTo("/topic/public")
	public ChatMessage addUser(@Payload ChatMessage chatMessage,
														 SimpMessageHeaderAccessor headerAccessor) {
		// Add username in web socket session
		log.info("add user "+chatMessage.getContent());
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}
}
