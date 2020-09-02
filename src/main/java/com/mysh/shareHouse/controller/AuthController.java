package com.mysh.shareHouse.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/signUpProc")
	public @ResponseBody ResponseEntity<?> signUpProc(@Valid @RequestBody User user, BindingResult bindingResult) {
		log.info("회원가입 객체정보 : " + user.toString());
		int entityUser = userService.signUp(user);
		
		CommonRespDto<?> respDto = CommonRespDto.builder()
				.statusCode(StatusCode.OK)
				.message("회원가입에 성공하였습니다.") // 이것도 인터페이스로 만드는게 좋음
				.data(""+entityUser)
				.build();
		return new ResponseEntity<CommonRespDto>(respDto, HttpStatus.CREATED);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/loginResp")
	public @ResponseBody ResponseEntity<?> loginResp() {
		CommonRespDto<?> respDto = CommonRespDto.builder()
				.statusCode(StatusCode.OK)
				.message("성공적으로 로그인하였습니다.") // 이것도 인터페이스로 만드는게 좋음
				.data("")
				.build();
		return new ResponseEntity<CommonRespDto>(respDto, HttpStatus.OK);
	}
}
