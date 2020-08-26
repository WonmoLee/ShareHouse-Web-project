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
public class User {
	private int id;
	private String userName;
	private String password;
	private String email;
	private int phNum;
	private char gender;
	private String terms;
	private String address;
	private String bankName;
	private String roleType;
	private String provider;
	private String providerId;
	private Timestamp createDate;
}
