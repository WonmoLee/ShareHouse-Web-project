package com.mysh.shareHouse.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mysh.shareHouse.service.HouseDetailService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RoomRVController {
	
	private final HouseDetailService houseDetailService;
	
	@GetMapping("/roomRV")
	public String roomRV(int houseNumber, Model model) {
		model.addAttribute("houseDetail", houseDetailService.houseDetailView(houseNumber));
		return "page/roomRV";
	}
}
