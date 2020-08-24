package com.mysh.shareHouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MoveInGuideController {

	@GetMapping("/moveInGuide")
	public String moveInGuide() {
		return "/page/moveInGuide";
	}
}
