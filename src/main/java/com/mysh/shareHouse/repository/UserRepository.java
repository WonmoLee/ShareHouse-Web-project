package com.mysh.shareHouse.repository;

import java.util.Optional;

import com.mysh.shareHouse.model.User;

public interface UserRepository {
	
	Optional<User> findByUsername(String username);
	void signUp(User user);
	Optional<User> findByEmail(String email);
	void oauthUserUpdate(User user);
	void pwUpdateProc(String userName, String password);
	void userInfoUDProc(int id, String userName, String email, int phNum, char gender, String terms, String address, String bankName);
}

