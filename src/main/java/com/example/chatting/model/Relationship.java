package com.example.chatting.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
@IdClass(Relationship.key.class)
public class Relationship {
	@Id
	private Long memberA;

	@Id
	private Long memberB;
	// status = 0 when a and b is friend ,
	// status = -1 when a send request add friend to b ,
	// status = 1 when b send request add friend to a ,
	private int status;
	class key implements Serializable {
		private String memberA;
		private String memberB;

	}
}
