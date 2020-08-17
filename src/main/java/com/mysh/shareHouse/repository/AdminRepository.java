package com.mysh.shareHouse.repository;

import com.mysh.shareHouse.model.HouseDetail;
import com.mysh.shareHouse.model.HouseDetailRoom;

public interface AdminRepository {
	public void HouseDeatailSave(HouseDetail HouseDeatail);
	public void HouseDeatailRoomSave(HouseDetailRoom houseDetailRoom);
	
}
