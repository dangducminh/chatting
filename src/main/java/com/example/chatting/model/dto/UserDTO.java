package com.example.chatting.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

	private String name;

	private String email;

	private String password;
}
