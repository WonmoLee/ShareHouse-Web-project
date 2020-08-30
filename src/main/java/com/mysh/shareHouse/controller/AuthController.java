package com.mysh.shareHouse.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysh.shareHouse.controller.dto.CommonRespDto;
import com.mysh.shareHouse.model.User;
import com.mysh.shareHouse.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AuthController {
	
	private static final Logger log = LoggerFactory.getLogger(AuthController.class);
	private final UserService userService;

	@GetMapping("/loginOrSignup")
	public String loginOrSignup() {
		log.info("로그인 및 회원가입 페이지 접근");
		return "/page/loginSignup"; 
	}
	
	@PostMapping("/signUpProc")
	public @ResponseBody CommonRespDto<?> signUpProc(@RequestBody User user) {
		log.info("회원가입 객체정보 : " + user.toString());
		userService.signUp(user);
		return new CommonRespDto<String>(1, "회원가입 성공");
	}
	
	@GetMapping("/loginResp")
	public @ResponseBody CommonRespDto<?> loginResp() {
		return new CommonRespDto<String>(1, "로그인에 성공하였습니다.");
	}
}
