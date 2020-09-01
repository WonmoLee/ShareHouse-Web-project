package com.mysh.shareHouse.config.handler.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

@SuppressWarnings("serial")
public class LoginException extends UsernameNotFoundException {

	public LoginException(String msg) {
		super(msg);
	}

}
