//package com.mysh.shareHouse.config.auth;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.mysh.shareHouse.model.User;
//import com.mysh.shareHouse.repository.UserRepository;
//
//// PrincipalDetailsService를 기본 UserDetailsService로 덮어 씌운다
////loadUserByUsername()은 AuthenticationManager가 호출하는 메서드
//@Service
//public class PrincipalDetailsService implements UserDetailsService{
//
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userRepository.findByUsername(username);
//		if(user == null) {
//			return null;
//		}else {
//			return new PrincipalDetails(user);
//		}
//		
//	}
//
//}
