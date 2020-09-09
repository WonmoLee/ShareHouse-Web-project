package com.mysh.shareHouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysh.shareHouse.controller.dto.CommonRespDto;
import com.mysh.shareHouse.model.Counsel;
import com.mysh.shareHouse.model.Faq;
import com.mysh.shareHouse.model.HouseDetail;
import com.mysh.shareHouse.model.HouseDetailRoom;
import com.mysh.shareHouse.model.Map;
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

	@GetMapping("/admin/index")
	public String adminIndex() {
		return "/admin/index";
	}

	@GetMapping("/admin/charts")
	public String adminCharts() {
		return "/admin/charts";
	}

	@GetMapping("/admin/houseSave")
	public String houseSaveR() {
		return "/admin/houseSave";
	}

	@GetMapping("/admin/houseUD")
	public String houseUD() {
		return "/admin/houseUD";
	}

	@GetMapping("/admin/houseDetailSave")
	public String houseDetailSave() {
		return "/admin/houseDetailSave";
	}

	@GetMapping("/admin/houseDetailRoomSave")
	public String houseDetailRoomSave() {
		return "/admin/houseDetailRoom";
	}

	@GetMapping("/admin/houseFaqSave")
	public String houseFaqSave() {
		return "/admin/adminFaq";
	}

	@GetMapping("/admin/houseDetailRoomUD")
	public String houseDetailRoomUD() {
		return "/admin/houseDetailRoomUD";
	}
	
	// 어드민 회원 탈퇴 관리 페이지 이동 및  회원 탈퇴 정보 전체 불러오기
	@GetMapping("/admin/memberSecessionAll")
	public String adminMemberSecessionAllProc(Model model) {
		model.addAttribute("Secessions", adminService.MemberSecessionAllProc());
		return "/admin/adminUserSecession";
	}
	
	// 상담답변 페이지 전체 불러오기
	@GetMapping("/admin/counselSelectAll")
	public String adminCounselSelectAllProc(Model model) {
		model.addAttribute("counsels", adminService.CounselSelectAllProc());
		return "/admin/adminCounsel";
	}

	// 상담 답변 페이지
	@GetMapping("/admin/counselAnswer")
	public String counselAnswer(int id, Model model) {
		model.addAttribute("counsel", adminService.CounselSelectByIdProc(id));
		// return "/admin/adminCounselAnswer";
		return "/admin/adminCounselAnswer";
	}

	// 하우스 디테일 업데이트 , 삭제페이지 이동
	@GetMapping("/admin/houseDetailUD")
	public String houseDetailUD() {
		return "/admin/houseDetailUD";
	}

	// FAQ 업데이트, 삭제 페이지 이동
	@GetMapping("/admin/houseFaqUD")
	public String houseFaqUD() {
		return "/admin/adminFaqUD";
	}

	// FAQ 수정,삭제페이지 검색
	@GetMapping("/admin/houseFaqSelect/{id}")
	public @ResponseBody String houseFaqSelect(@PathVariable int id) {
		Faq faq = adminService.adminHouseFaqSelect(id);
		ObjectMapper mapper = new ObjectMapper();
		String jsonList = "";
		try {
			jsonList = mapper.writeValueAsString(faq);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonList;
	}

	// 방찾기 검색
	@GetMapping("/admin/houseSelect/{houseNumber}")
	public @ResponseBody String houseSelect(@PathVariable int houseNumber) {
		Map map = adminService.adminHouseSelect(houseNumber);
		ObjectMapper mapper = new ObjectMapper();
		String jsonList = "";
		try {
			jsonList = mapper.writeValueAsString(map);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonList;
	}

	// 하우스 디테일 룸 수정,삭제 페이지 검색
	@GetMapping("/admin/houseDetailRoomSelect")
	public @ResponseBody String houseDetailRoomSelect(int house_num, String roomName) {
		HouseDetailRoom houseDetailRoom = adminService.adminHouseDetailRoomSelect(house_num, roomName);
		ObjectMapper mapper = new ObjectMapper();
		String jsonList = "";
		try {
			jsonList = mapper.writeValueAsString(houseDetailRoom);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonList;
	}

	// 하우스 디테일 수정,삭제페이지 검색
	@GetMapping("/admin/houseDetailSelect/{houseNumber}")
	public @ResponseBody String houseDetailSelect(@PathVariable int houseNumber) {
		HouseDetail houseDetail = adminService.adminHouseDetailSelect(houseNumber);
		ObjectMapper mapper = new ObjectMapper();
		String jsonList = "";
		try {
			jsonList = mapper.writeValueAsString(houseDetail);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonList;
	}

	// 방찾기 페이지 등록
	@PostMapping("/admin/houseSave")
	public @ResponseBody CommonRespDto<?> houseSave(@RequestBody Map map) {
		adminService.adminHouseSaveProc(map);
		return new CommonRespDto<String>(1, "등록 성공", "");
	}

	// 하우스 디테일 페이지 등록
	@PostMapping("/admin/houseDetail")
	public @ResponseBody CommonRespDto<?> houseDetailProc(@RequestBody HouseDetail houseDetail) {
		System.out.println("houseDetail : " + houseDetail);
		adminService.adminHouseDetailProc(houseDetail);
		return new CommonRespDto<String>(1, "등록 성공", "");
	}

	// 하우스 디테일 룸 정보 추가

	@PostMapping("/admin/houseDetailRoom")
	public @ResponseBody CommonRespDto<?> houseDetailRoomProc(@RequestBody HouseDetailRoom houseDetailRoom) {
		adminService.adminHouseDetailRoomProc(houseDetailRoom);
		return new CommonRespDto<String>(1, "등록 성공", "");
	}

	// FAQ 추가
	@PostMapping("/admin/houseFaq")
	public @ResponseBody CommonRespDto<?> houseFaqProc(@RequestBody Faq faq) {
		adminService.adminHouseFaqProc(faq);
		return new CommonRespDto<String>(1, "등록 성공", "");
	}

	// FAQ 업데이트
	@PutMapping("/admin/houseFaqUpdate")
	public @ResponseBody CommonRespDto<?> houseFaqUpdateProc(@RequestBody Faq faq) {
		adminService.adminHouseUpdateProc(faq);
		return new CommonRespDto<String>(1, "수정성공", "");
	}

	// FAQ 삭제
	@DeleteMapping("/admin/houseFaqDelete/{id}")
	public @ResponseBody CommonRespDto<?> houseFaqDeleteProc(@PathVariable int id) {
		adminService.adminHouseFaqDeleteById(id);
		return new CommonRespDto<String>(1, "삭제성공", "");
	}

	// 하우스 디테일 업데이트
	@PutMapping("/admin/houseDetailUpdate")
	public @ResponseBody CommonRespDto<?> houseDetailUpdateProc(@RequestBody HouseDetail houseDetail) {
		adminService.adminHouseDetailUpdateProc(houseDetail);
		return new CommonRespDto<String>(1, "수정성공", "");
	}

	// 하우스 디테일 삭제
	@DeleteMapping("/admin/houseDetailDelete/{id}")
	public @ResponseBody CommonRespDto<?> houseDetailDeleteProc(@PathVariable int id) {
		adminService.adminHouseDetailDeleteById(id);
		return new CommonRespDto<String>(1, "삭제성공", "");
	}

	// 방찾기 업데이트
	@PutMapping("/admin/houseUpdate")
	public @ResponseBody CommonRespDto<?> houseUpdateProc(@RequestBody Map map) {
		adminService.adminHouseUpdateProc(map);
		return new CommonRespDto<String>(1, "수정성공", "");
	}

	// 방찾기 삭제
	@DeleteMapping("/admin/houseDelete/{id}")
	public @ResponseBody CommonRespDto<?> houseDeleteProc(@PathVariable int id) {
		adminService.adminHouseDeleteById(id);
		return new CommonRespDto<String>(1, "삭제성공", "");
	}

	// 하우스 디테일 룸 업데이트
	@PutMapping("/admin/houseDetailRoomUpdate")
	public @ResponseBody CommonRespDto<?> houseDetailRoomUpdateProc(@RequestBody HouseDetailRoom houseDetailRoom) {
		adminService.adminHouseDetailRoomUpdateProc(houseDetailRoom);
		return new CommonRespDto<String>(1, "수정성공", "");
	}

	// 하우스 디테일 룸 삭제
	@DeleteMapping("/admin/houseDetailRoomDelete/{id}")
	public @ResponseBody CommonRespDto<?> houseDetailRoomDeleteProc(@PathVariable int id) {
		adminService.adminHouseDetailRoomDeleteById(id);
		return new CommonRespDto<String>(1, "삭제성공", "");
	}

	// 하우스 디테일 룸 전체 삭제
	@DeleteMapping("/admin/houseDetailRoomDeleteAll/{house_num}")
	public @ResponseBody CommonRespDto<?> houseDetailRoomDeleteAllProc(@PathVariable int house_num) {
		adminService.adminHouseDetailRoomDeleteByAll(house_num);
		return new CommonRespDto<String>(1, "삭제성공", "");
	}

	// 상담 업데이트
	@PutMapping("/admin/counselAnswerUpdate")
	public @ResponseBody CommonRespDto<?> counselAnswerUpdateProc(@RequestBody Counsel counsel) {
		adminService.adminCounselAnswerUpdateProc(counsel);
		return new CommonRespDto<String>(1, "수정성공", "");
	}

	// 상담 삭제
	@DeleteMapping("/admin/counselAnswerDelete/{id}")
	public @ResponseBody CommonRespDto<?> counselAnswerDeleteProc(@PathVariable int id) {
		adminService.adminCounselAnswerDeleteById(id);
		return new CommonRespDto<String>(1, "삭제성공", "");
	}
	
	// 회원정보 삭제
	@DeleteMapping("/admin/secessionDelete/{userId}")
	public @ResponseBody CommonRespDto<?> userSecessionDeleteProc(@PathVariable int userId) {
		adminService.adminUserSecessionDeleteByUserId(userId);
		adminService.adminUserSecessionCancelByUserId(userId);
		return new CommonRespDto<String>(1, "삭제성공", "");
	}
	
	// 회원 탈퇴 취소
	@DeleteMapping("/admin/secessionCancel/{userId}")
	public @ResponseBody CommonRespDto<?> userSecessionCancelProc(@PathVariable int userId) {
		adminService.adminUserSecessionCancelByUserId(userId);
		return new CommonRespDto<String>(1, "삭제성공", "");
	}
	
	
	

	

}
