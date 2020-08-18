package com.mysh.shareHouse.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mysh.shareHouse.model.Map;
import com.mysh.shareHouse.repository.AdminRepository;
import com.mysh.shareHouse.service.AdminService;
import com.mysh.shareHouse.service.HouseDetailService;
import com.mysh.shareHouse.service.MapService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IndexController {
	

	private final MapService mapService;
	private final HouseDetailService houseDetailService;
	
	@GetMapping({"", "/"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/moveInGuide")
	public String moveInGuide() {
		return "/page/moveInGuide";
	}
	
	@GetMapping("/putOutRoom")
	public String putOutRoom() {
		return "/page/putOutRoom";
	}
	
	
	@GetMapping("/test/all")
	public @ResponseBody String AllTest(Model model) {
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
	
	@GetMapping("/test")
	public String test() {
		return "/page/test";
	}
	
	@GetMapping("/test2")
	public String test2() {
		return "/page/test2";
	}
	
	@GetMapping("/test3")
	public String test3() {
		return "/page/test3";
	}
	
	
	@GetMapping("/insert")
	public String insert() {
		return "/page/test3";
	}
	
	
	
	@GetMapping("/test/map")
	public @ResponseBody String testMap(double latMin, double lngMin,double latMax, double lngMax) {
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
