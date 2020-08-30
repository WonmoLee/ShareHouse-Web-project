package com.mysh.shareHouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mysh.shareHouse.config.auth.PrincipalDetails;
import com.mysh.shareHouse.model.Interview;
import com.mysh.shareHouse.service.ItvService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IndexController {
	
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);
	private final ItvService itvService;
	
	@GetMapping({"", "/"})
	public String index(Model model, @AuthenticationPrincipal PrincipalDetails principal) {
		log.info("인증허가 유저정보 : " + principal);
		List<Interview> itvList = itvService.findAll();
		model.addAttribute("itvList", itvList);
		return "index";
	}
	
}
