package com.mysh.shareHouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginSignupController {

	@GetMapping("/loginOrSignup")
	public String loginOrSignup() {
		return "/page/loginSignup"; 
	}
	
}
