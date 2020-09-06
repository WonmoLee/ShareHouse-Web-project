package com.mysh.shareHouse.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mysh.shareHouse.config.auth.PrincipalDetails;
import com.mysh.shareHouse.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class MyPageController {
	
	private static final Logger log = LoggerFactory.getLogger(MyPageController.class);
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//페이지 이동
	@GetMapping("/myPageMain")
	public String myPageMain() {
		return "page/myPage/myPageMain";
	}
	
	@GetMapping("/myPageInfoUD")
	public String myPageInfoUD(@AuthenticationPrincipal PrincipalDetails principal, Model model) {
		model.addAttribute("pricipalUser", principal);
		return "page/myPage/userInfoUD";
	}
	
	@GetMapping("/myPagePWUpdate")
	public String myPagePWUpdate() {
		return "page/myPage/myPagePWUpdate";
	}
	
	//서비스
	@PostMapping("pwUpdateProc")
	public String pwUpdateProc(@AuthenticationPrincipal PrincipalDetails principal, String udPassword) {
		String password = bCryptPasswordEncoder.encode(udPassword);
		userRepository.pwUpdateProc(principal.getUsername(), password);
		log.info("비밀번호 변경완료");
		return "page/myPage/myPageMain";
	}
	
	@PostMapping("userInfoUD")
	public String userInfoUDProc(@AuthenticationPrincipal PrincipalDetails principal, String userName, String email, int phNum, char gender, String terms, String address, String bankName) {
		userRepository.userInfoUDProc(principal.getUser().getId(), userName, email, phNum, gender, terms, address, bankName);
		log.info("회원정보 수정완료");
		return "page/myPage/myPageMain";
	}
}
