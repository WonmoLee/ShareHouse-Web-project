package com.mysh.shareHouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysh.shareHouse.controller.dto.CommonRespDto;
import com.mysh.shareHouse.model.HouseDetail;
import com.mysh.shareHouse.model.HouseDetailRoom;
import com.mysh.shareHouse.service.AdminService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminController {
	
	private final AdminService adminService;
	
	@GetMapping("/admin")
	public String admin() {
		return "/admin/admin";
	}
	
	@GetMapping("/admin/houseDetailSave")
	public String houseDetailSave() {
		return "/admin/houseDetailSave";
	}
	
	
	@GetMapping("/admin/houseDetailRoomSave")
	public String houseDetailRoomSave() {
		return "/admin/houseDetailRoom";
	}
	
	@PostMapping("/admin/houseDetail")
	public @ResponseBody CommonRespDto<?> houseDetailProc(@RequestBody HouseDetail houseDetail) {
		adminService.adminHouseDetailProc(houseDetail);
		return new CommonRespDto<String>(1, "등록 성공", ""+houseDetail);
	}
	
	@PostMapping("/admin/houseDetailRoom")
	public @ResponseBody CommonRespDto<?> houseDetailRoomProc(@RequestBody HouseDetailRoom houseDetailRoom) {
		adminService.adminHouseDetailRoomProc(houseDetailRoom);
		return new CommonRespDto<String>(1, "등록 성공", ""+houseDetailRoom);
	}
	
	
}
