package com.mysh.shareHouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PutOutRoomController {

	@GetMapping("/putOutRoom/info")
	public String putOutRoomInfo() {
		return "/page/serviceInfo";
	}
	
	@GetMapping("/putOutRoom/directManagement")
	public String directManagement() {
		return "/page/directManagement";
	}
	
	@GetMapping("/putOutRoom/entrust")
	public String entrust() {
		return "/page/entrust";
	}
	
}
