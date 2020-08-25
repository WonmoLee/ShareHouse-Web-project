package com.mysh.shareHouse.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysh.shareHouse.model.Map;
import com.mysh.shareHouse.service.HouseDetailService;
import com.mysh.shareHouse.service.MapService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HouseController {

	private final MapService mapService;
	private final HouseDetailService houseDetailService;
	
	
	@GetMapping("/houseMap/all")
	public @ResponseBody String AllHouseMap(Model model) {
		List<Map> allMaps = mapService.목록보기();
		ObjectMapper allMapper = new ObjectMapper(); 
		String allJsonList=""; 
		try { 
			allJsonList = allMapper.writeValueAsString(allMaps); 
		} catch (Exception e) { 
			e.printStackTrace(); 
		}

		return allJsonList;
	}
	
	@GetMapping("/houseMap")
	public String houseMap() {
		return "/page/houseMap";
	}
	
	@GetMapping("/houseMap/map")
	public @ResponseBody String houseMap(double latMin, double lngMin,double latMax, double lngMax) {
		//model.addAttribute("Maps", mapService.지도목록보기(latMin,lngMin,latMax,lngMax));
		List<Map> maps = mapService.지도목록보기(latMin,lngMin,latMax,lngMax);
		ObjectMapper mapper = new ObjectMapper(); 
		String jsonList=""; 
		try { 
			jsonList = mapper.writeValueAsString(maps); 
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
	
		return jsonList;
	}
	
	@GetMapping("/page/houseDetail/{houseNumber}")
	public String houseDetailPage(@PathVariable int houseNumber, Model model, Model roomModel, Model houseArea) {
		model.addAttribute("houseDetail", houseDetailService.houseDetailView(houseNumber));
		roomModel.addAttribute("houseDetailRooms", houseDetailService.houseDetailRoomView(houseNumber));
		houseArea.addAttribute("house", houseDetailService.houseArea(houseNumber));
		System.out.println(model);
		System.out.println(roomModel);
		System.out.println(houseArea);
		return "/page/houseDetail";
	}
}
