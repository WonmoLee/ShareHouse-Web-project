package com.mysh.shareHouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysh.shareHouse.model.User;
import com.mysh.shareHouse.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public User loginProc(User user) {
		return userRepository.loginProc(user);
	}
	
	@Transactional
	public int signUp(User user) {
		try {
			user.setRoleType("USER");
			userRepository.signUp(user);
			return 1;
		} catch (Exception e) {
			e.getMessage();
			return -1;
		}
		
	}
}
