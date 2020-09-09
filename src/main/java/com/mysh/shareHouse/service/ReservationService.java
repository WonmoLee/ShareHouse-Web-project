package com.mysh.shareHouse.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysh.shareHouse.repository.ReservationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService {
	
	private final ReservationRepository reservationRepository;
	
	@Transactional
	public int rvSignup(String userName, int phNum, int houseNum) {
		return reservationRepository.rvSignup(userName, phNum, houseNum);
	}
}
