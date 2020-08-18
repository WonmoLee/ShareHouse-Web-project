package com.mysh.shareHouse.repository;

import java.util.List;

import com.mysh.shareHouse.model.HouseDetail;
import com.mysh.shareHouse.model.HouseDetailRoom;
import com.mysh.shareHouse.model.Map;

public interface HouseDetailRepository {
	public HouseDetail houseDetailLoad(int houseNumber);
	public List<HouseDetailRoom> houseDetailRoomLoad(int houseNumber);
	public Map houseMapArea(int houseNumber);
}
