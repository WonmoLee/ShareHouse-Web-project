package com.mysh.shareHouse.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysh.shareHouse.model.HouseDetail;
import com.mysh.shareHouse.repository.RoomRVRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomRVService {
	
	private final RoomRVRepository roomRVRepository;

	@Transactional(readOnly = true)
	public HouseDetail findById() {
		return roomRVRepository.findById();
	}
}
