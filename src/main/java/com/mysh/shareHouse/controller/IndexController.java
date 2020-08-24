package com.mysh.shareHouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mysh.shareHouse.model.Interview;
import com.mysh.shareHouse.service.ItvService;



@Controller
public class IndexController {
	
	@Autowired
	private ItvService itvService;
	
	@GetMapping({"", "/"})
	public String index(Model model) {
		List<Interview> itvList = itvService.findAll();
		model.addAttribute("itvList", itvList);
		return "index";
	}
	
}
