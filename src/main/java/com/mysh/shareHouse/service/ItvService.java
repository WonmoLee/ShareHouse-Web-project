package com.mysh.shareHouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysh.shareHouse.model.Interview;
import com.mysh.shareHouse.repository.ItvRepository;

@Service
public class ItvService {
	
	@Autowired 
	private ItvRepository itvRepository;
	
	@Transactional(readOnly = true)
	public List<Interview> findAll() {
		return itvRepository.findAll();
	}
}
