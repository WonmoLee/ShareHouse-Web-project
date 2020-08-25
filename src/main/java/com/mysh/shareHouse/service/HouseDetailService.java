package com.mysh.shareHouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysh.shareHouse.model.HouseDetail;
import com.mysh.shareHouse.model.HouseDetailRoom;
import com.mysh.shareHouse.model.Map;
import com.mysh.shareHouse.repository.HouseDetailRepository;

@Service
public class HouseDetailService {
	
	@Autowired
	private HouseDetailRepository houseDetailRepositoy;
	

	@Transactional
	public HouseDetail houseDetailView(int houseNumber) {
		return houseDetailRepositoy.houseDetailLoad(houseNumber);
	}
	
	
	@Transactional
	public List<HouseDetailRoom> houseDetailRoomView(int houseNumber) {
		return houseDetailRepositoy.houseDetailRoomLoad(houseNumber);
	}
	
	@Transactional
	public Map houseArea(int houseNumber) {
		return houseDetailRepositoy.houseMapArea(houseNumber);
	}
	
	
}
