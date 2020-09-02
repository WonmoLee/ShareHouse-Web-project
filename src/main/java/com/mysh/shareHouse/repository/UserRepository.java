package com.mysh.shareHouse.repository;

import java.util.Optional;

import com.mysh.shareHouse.model.User;

public interface UserRepository {
	
	Optional<User> findByUsername(String username);
	void signUp(User user);
	Optional<User> findByEmail(String email);
	
}
