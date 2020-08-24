package com.mysh.shareHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mysh.shareHouse.service.FAQService;

@Controller
public class FaqController {
	
	@Autowired
	private FAQService faqService;
	
	@GetMapping("/faq/living")
	public String faqLiving(Model model) {
		model.addAttribute("faqMoveInList", faqService.findByMoveIn());
		return "/page/moveInFaq";
	}
	
	@GetMapping("/faq/contract")
	public String faqContract(Model model) {
		model.addAttribute("faqContractList", faqService.findByContract());
		return "/page/contractFaq";
	}
}
