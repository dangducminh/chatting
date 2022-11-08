package com.example.chatting.repository;

import com.example.chatting.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositori extends JpaRepository<User,Long> {
	User findAllByEmailAndPassword(String email, String password);

	List<User> findByNameContaining(String word);
}
