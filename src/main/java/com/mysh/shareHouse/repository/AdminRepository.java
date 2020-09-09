package com.mysh.shareHouse.repository;

import java.util.List;

import com.mysh.shareHouse.model.Counsel;
import com.mysh.shareHouse.model.Faq;
import com.mysh.shareHouse.model.HouseDetail;
import com.mysh.shareHouse.model.HouseDetailRoom;
import com.mysh.shareHouse.model.Map;
import com.mysh.shareHouse.model.MemberSecession;

public interface AdminRepository {
	public void HouseDeatailSave(HouseDetail HouseDeatail);
	public void HouseDeatailRoomSave(HouseDetailRoom houseDetailRoom);
	public void HouseSave(Map map);
 	public void HouseFaqSave(Faq faq);
 	public List<Counsel> CounselSelectAll();
 	public List<MemberSecession> MemberSecessionAll();
 	public Counsel CounselSelectById(int id);
 	public Faq HouseFaqSelect(int id);
 	public HouseDetail HouseDetailSelect(int houseNumber);
 	public Map HouseSelect(int houseNumber);
 	public HouseDetailRoom HouseDetailRoomSelect(int house_num, String roomName);
 	public void HouseFaqUpdate(Faq faq);
 	public void HouseFaqDeleteById(int id);
 	public void HouseDetailUpdate(HouseDetail houseDetail);
 	public void HouseDetailDeleteById(int id);
 	public void HouseUpdate(Map map);
 	public void HouseDeleteById(int id);
 	public void HouseDetailRoomUpdate(HouseDetailRoom houseDetailRoom);
 	public void HouseDetailRoomDeleteById(int id);
 	public void HouseDetailRoomDeleteByAll(int house_num);
 	public void CounselAnswerUpdate(Counsel counsel);
 	public void CounselAnswerDeleteById(int id);
 	public void UserSecessionDeleteByUserId(int userId);
 	public void UserSecessionCancelByUserId(int userId);
 
}