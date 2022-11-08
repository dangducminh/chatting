package com.example.chatting.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long uid;

	private String name;

	@Column(unique=true)
	private String email;

	private String password;

}
