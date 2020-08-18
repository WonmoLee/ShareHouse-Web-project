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
public class HouseDetail {
	private int id;
	private int house_num;
	private String img1;
	private String img2;
	private String img3;
	private String title;
	private String content;
	private String hash_tag;
	private String tourPoint;
	private String address;
	
	private char gender;
	private String contractEndDate;
	private String maxResidencePersonnel;
	private String house_form;
	private String construction;
	private String drawing;
	private String tourApply;
	private String subway;
	private String bus;
	private String university;
	
	private String mart;
	private String facilities;
	private String heal;
	private Timestamp create_date;
}
