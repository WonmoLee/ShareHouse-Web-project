package com.mysh.shareHouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysh.shareHouse.model.Map;
import com.mysh.shareHouse.repository.TestRepository;

@Service
public class MapService {
	
	@Autowired
	private TestRepository testRepository;
	
	
	@Transactional(readOnly = true)
	public List<Map> 목록보기() {
		 return testRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<Map> 지도목록보기(double latMin, double lngMin,double latMax, double lngMax) {
		
		 return testRepository.findByMap(latMin, lngMin, latMax, lngMax);
	}


}
