package com.mysh.shareHouse.repository;

import java.util.Optional;

import com.mysh.shareHouse.model.User;

public interface UserRepository {
	
	User findByUsername(String username);
	Optional<User> findByEmail(String email);
	User save(User user);
}
