package com.mysh.shareHouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FindRoomController {

	@GetMapping("/findRoom")
	public String findRoom() {
		return "/page/findRoom";
	}
}
