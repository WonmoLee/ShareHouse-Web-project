package com.mysh.shareHouse.controller;

import java.util.List;

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
import com.mysh.shareHouse.service.MapService;

@Controller
public class IndexController {
	
	@Autowired
	MapService mapService;
	
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
	
	
	@GetMapping("/test")
	//@RequestMapping("/test")
	//@RequestMapping(value = "/test")
	public String test() {
		return "/page/test";
	}
	
	@GetMapping("/test/all")
	public @ResponseBody String testAllMap() {
		List<Map> allMaps = mapService.목록보기();	
		ObjectMapper allMapper = new ObjectMapper(); 
		String jsonAllList=""; 
		try { 
			jsonAllList = allMapper.writeValueAsString(allMaps); 
		} catch (Exception e) { 
			e.printStackTrace(); 
		}

		return jsonAllList;
	}
	
	@GetMapping("/test2")
	public String test2() {
		return "/page/test2";
	}
	
	@GetMapping("/test3")
	public String test3() {
		return "/page/test3";
	}
	
	
	@GetMapping("/test/map")
	public @ResponseBody String testMap(double latMin, double lngMin,double latMax, double lngMax) {
		
		//model.addAttribute("Maps", mapService.지도목록보기(latMin,lngMin,latMax,lngMax));
		List<Map> maps = mapService.지도목록보기(latMin,lngMin,latMax,lngMax);
		
		
//		String jsonStr = "";
//		try {
//			ObjectMapper mapper = new ObjectMapper();
//			JSONPObject json = new JSONPObject("JSON.parse", maps);
//			jsonStr = mapper.writeValueAsString(json);
//			System.out.println("jsonStr : " +jsonStr);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String jsonMap = jsonStr.replace("JSON.parse", "Map").replace(")", "");
		
		ObjectMapper mapper = new ObjectMapper(); 
		String jsonList=""; 
		try { 
			jsonList = mapper.writeValueAsString(maps); 
		} catch (Exception e) { 
			e.printStackTrace(); 
		}

		
		
		return jsonList;
	}
	
}
