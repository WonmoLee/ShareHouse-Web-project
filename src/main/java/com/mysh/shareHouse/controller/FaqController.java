package com.mysh.shareHouse.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FaqController {

//	@Autowired
//	private FAQService faqService;

	@GetMapping("/faq/living")
	public String faqLiving() {
//		model.addAttribute("faqLiving", faqService.findAll());
		return "/page/moveInFaq";
	}

	@GetMapping("/faq/contract")
	public String faqContract() {
		return "/page/contractFaq";
	}


}
