package com.mysh.shareHouse.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HouseDetailRoom {
	private int id;
	private int houseNumber;
	private String roomName;
	private String gender;
	private String type;
	private String area;
	private String deposit;
	private String monthly;
	private String moveInDate;
	private Timestamp createDate;
}
