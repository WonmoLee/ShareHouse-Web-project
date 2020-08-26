package com.mysh.shareHouse.repository;

import java.util.Optional;

import com.mysh.shareHouse.model.User;

public interface UserRepository {
	
	User loginProc(User user);
	User signUp(User user);
	Optional<User> findByEmail(String email);
	
}
