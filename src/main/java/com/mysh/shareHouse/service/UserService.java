package com.mysh.shareHouse.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysh.shareHouse.model.User;
import com.mysh.shareHouse.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional
	public int signUp(User user) {
		try {
			String encPassword = bCryptPasswordEncoder.encode(user.getPassword());
			user.setPassword(encPassword);
			user.setRoleType("USER");
			userRepository.signUp(user);
			log.info("신규 회원가입 : " + user);
			return 1;
		} catch (Exception e) {
			e.getMessage();
			return -1;
		}
		
	}
}
