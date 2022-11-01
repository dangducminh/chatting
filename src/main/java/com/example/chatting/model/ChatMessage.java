package com.example.chatting.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChatMessage {
	private MessageType type;
	private String content;
	private String sender;

	public ChatMessage(MessageType type, String content, String sender) {
		this.type = type;
		this.content = content;
		this.sender = sender;
	}

	public enum MessageType {
		CHAT,
		JOIN,
		LEAVE
	}

	@Override
	public String toString() {
		return "ChatMessage{" +
						"type=" + type +
						", content='" + content + '\'' +
						", sender='" + sender + '\'' +
						'}';
	}
}
