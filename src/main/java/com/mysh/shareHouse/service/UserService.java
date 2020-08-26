package com.mysh.shareHouse.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysh.shareHouse.model.User;
import com.mysh.shareHouse.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional(readOnly = true)
	public User loginProc(User user) {
		return userRepository.loginProc(user);
	}
	
	@Transactional
	public int signUp(User user) {
		try {
			String encPassword = bCryptPasswordEncoder.encode(user.getPassword());
			user.setPassword(encPassword);
			user.setRoleType("USER");
			userRepository.signUp(user);
			return 1;
		} catch (Exception e) {
			e.getMessage();
			return -1;
		}
		
	}
}
