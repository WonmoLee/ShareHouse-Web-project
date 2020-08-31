package com.mysh.shareHouse.config.handler;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.mysh.shareHouse.config.handler.exception.LoginException;


@ControllerAdvice //IoC 등록됨. Exception을 낚아 채는 컨트롤러
@RestController
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = LoginException.class)
	public String loginException(Exception e) {
		return "";
	}
	
}
