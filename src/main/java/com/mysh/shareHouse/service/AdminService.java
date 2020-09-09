package com.mysh.shareHouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysh.shareHouse.model.Counsel;
import com.mysh.shareHouse.model.Faq;
import com.mysh.shareHouse.model.HouseDetail;
import com.mysh.shareHouse.model.HouseDetailRoom;
import com.mysh.shareHouse.model.Map;
import com.mysh.shareHouse.model.MemberSecession;
import com.mysh.shareHouse.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Transactional
	public void adminHouseDetailProc(HouseDetail houseDetail) {
		adminRepository.HouseDeatailSave(houseDetail);
	}
	
	@Transactional
	public void adminHouseDetailRoomProc(HouseDetailRoom houseDetailRoom) {
		adminRepository.HouseDeatailRoomSave(houseDetailRoom);
	}
	
	@Transactional
	public void adminHouseSaveProc(Map map) {
		adminRepository.HouseSave(map);
	}
	
	
	@Transactional
	public void adminHouseFaqProc(Faq faq) {
		adminRepository.HouseFaqSave(faq);
	}
	
	@Transactional(readOnly = true)
	public Faq adminHouseFaqSelect(int id) {
		
		 return adminRepository.HouseFaqSelect(id);
	}
	
	@Transactional(readOnly = true)
	public List<Counsel> CounselSelectAllProc() {
		
		return adminRepository.CounselSelectAll();
	}
	
	@Transactional(readOnly = true)
	public List<MemberSecession> MemberSecessionAllProc() {
		
		return adminRepository.MemberSecessionAll();
	}
	
	
	
	
	@Transactional(readOnly = true)
	public Counsel CounselSelectByIdProc(int id) {
		
		return adminRepository.CounselSelectById(id);
	}
	
	
	@Transactional(readOnly = true)
	public HouseDetail adminHouseDetailSelect(int houseNumber) {
		
		 return adminRepository.HouseDetailSelect(houseNumber);
	}
	
	@Transactional(readOnly = true)
	public Map adminHouseSelect(int houseNumber) {
		 return adminRepository.HouseSelect(houseNumber);
	}
	
	@Transactional(readOnly = true)
	public HouseDetailRoom adminHouseDetailRoomSelect(int house_num, String roomName) {
		return adminRepository.HouseDetailRoomSelect(house_num, roomName);
	}

	@Transactional
	public void adminHouseUpdateProc(Faq faq) {
		adminRepository.HouseFaqUpdate(faq);
	}
	
	@Transactional
	public void adminHouseFaqDeleteById(int id) {
		adminRepository.HouseFaqDeleteById(id);
	}
	
	// 하우스 디테일 업데이트
	@Transactional
	public void adminHouseDetailUpdateProc(HouseDetail houseDetail) {
		adminRepository.HouseDetailUpdate(houseDetail);
	}
	
	// 하우스 디테일 삭제
	@Transactional
	public void adminHouseDetailDeleteById(int id) {
		adminRepository.HouseDetailDeleteById(id);
	}
	
	// 방 찾기 업데이트
	@Transactional
	public void adminHouseUpdateProc(Map map) {
		adminRepository.HouseUpdate(map);
	}
		
	// 방 찾기 삭제
	@Transactional
	public void adminHouseDeleteById(int id) {
		adminRepository.HouseDeleteById(id);
	}
	
	// 하우스 디테일 룸 업데이트
	@Transactional
	public void adminHouseDetailRoomUpdateProc(HouseDetailRoom houseDetailRoom) {
		adminRepository.HouseDetailRoomUpdate(houseDetailRoom);
	}
	
	// 하우스 디테일 룸 삭제
	@Transactional
	public void adminHouseDetailRoomDeleteById(int id) {
		adminRepository.HouseDetailRoomDeleteById(id);
	}
	
	// 하우스 디테일 룸 전체 삭제
	@Transactional
	public void adminHouseDetailRoomDeleteByAll(int house_num) {
		adminRepository.HouseDetailRoomDeleteByAll(house_num);
	}
	
	// 상담 답변 업데이트
	@Transactional
	public void adminCounselAnswerUpdateProc(Counsel counsel) {
		adminRepository.CounselAnswerUpdate(counsel);
	}
	
	// 상담 답변 삭제
	@Transactional
	public void adminCounselAnswerDeleteById(int id) {
		adminRepository.CounselAnswerDeleteById(id);
	}
	
	// 회원 정보 삭제
	@Transactional
	public void adminUserSecessionDeleteByUserId(int userId) {
		adminRepository.UserSecessionDeleteByUserId(userId);
	}
	
	// 회원 정보 삭제 취소
	@Transactional
	public void adminUserSecessionCancelByUserId(int userId) {
		adminRepository.UserSecessionCancelByUserId(userId);
	}
	
}
