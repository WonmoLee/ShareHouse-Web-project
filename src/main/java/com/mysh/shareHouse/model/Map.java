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
public class Map {
	int id;
	char discountType;
	String imageTitle;
	String nearStation;
	int houseNumber;
	double lat;
	double lng;
	String area;
	char genderType;
	char reservation;
	String houseForm;
	Timestamp create_date;
}
