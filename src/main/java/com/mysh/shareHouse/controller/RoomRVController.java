package com.mysh.shareHouse.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mysh.shareHouse.config.auth.PrincipalDetails;
import com.mysh.shareHouse.service.HouseDetailService;
import com.mysh.shareHouse.service.ReservationService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RoomRVController {
	
	private final HouseDetailService houseDetailService;
	private final ReservationService reservationService;
	
	@GetMapping("/roomRV")
	public String roomRV(int houseNumber, Model model) {
		model.addAttribute("houseDetail", houseDetailService.houseDetailView(houseNumber));
		return "page/roomRV";
	}
	
	@PostMapping("/rvProc")
	public String rvProc(@AuthenticationPrincipal PrincipalDetails principal, int houseNum) {
		reservationService.rvSignup(principal.getUsername(), principal.getUser().getPhNum(), houseNum);
		return "page/rvConfirm";
	}
}
