package com.mysh.shareHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysh.shareHouse.controller.dto.CommonRespDto;
import com.mysh.shareHouse.model.User;
import com.mysh.shareHouse.service.UserService;

@Controller
public class LoginSignupController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/loginOrSignup")
	public String loginOrSignup() {
		return "/page/loginSignup"; 
	}
	
	@GetMapping("/loginProc")
	public String loginProc(User user) {
		userService.loginProc(user);
		return "index";
	}
	
	@PostMapping("/signUpProc")
	public @ResponseBody CommonRespDto<?> signUpProc(@RequestBody User user) {
		System.out.println(user);
		userService.signUp(user);
		return new CommonRespDto<String>(1, "회원가입 성공");
	}
	
}
