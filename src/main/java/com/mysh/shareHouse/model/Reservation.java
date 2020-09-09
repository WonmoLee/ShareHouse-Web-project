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
public class Reservation {
	
	private int id;
	private String userName;
	private int phNum;
	private int houseNum;
	private Timestamp createDate;
	
}
