package com.example.chatting.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestLogin {
	private String email;
	private String password;
}
