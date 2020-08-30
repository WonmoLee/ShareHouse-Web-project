package com.mysh.shareHouse.config.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mysh.shareHouse.model.User;
import com.mysh.shareHouse.repository.UserRepository;

import lombok.RequiredArgsConstructor;

// PrincipalDetailsService를 기본 UserDetailsService로 덮어 씌운다
//loadUserByUsername()은 AuthenticationManager가 호출하는 메서드
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService{

	private static final Logger log = LoggerFactory.getLogger(PrincipalDetailsService.class);
	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("로그인 요청ID : " + username);
		User userEntity = userRepository.findByUsername(username);
		log.info("요청ID 정보 : " + userEntity);
		if(userEntity == null) {
			return null;
		} else {
			return new PrincipalDetails(userEntity);
		}
		
	}

}
