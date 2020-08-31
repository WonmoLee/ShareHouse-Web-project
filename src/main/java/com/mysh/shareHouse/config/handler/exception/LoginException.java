package com.mysh.shareHouse.config.handler.exception;


public class LoginException extends RuntimeException {

	private String message;
	
	public LoginException() {
		this.message = "존재하지 않는 ID로 로그인 시도";
	}
	
	public LoginException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
