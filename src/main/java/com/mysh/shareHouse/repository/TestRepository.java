package com.mysh.shareHouse.repository;

import java.util.List;

import com.mysh.shareHouse.model.Map;

public interface TestRepository {
	public List<Map> findByMap(double latMin, double lngMin,double latMax, double lngMax);
	public List<Map> findAll();

}
