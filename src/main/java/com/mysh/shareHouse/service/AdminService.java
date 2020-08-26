package com.mysh.shareHouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysh.shareHouse.model.HouseDetail;
import com.mysh.shareHouse.model.HouseDetailRoom;
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

}

