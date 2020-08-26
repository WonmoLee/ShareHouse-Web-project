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
	private String username;
	private String password;
	private String email;
	private int ph_num;
	private char gender;
	private String terms;
	private String address;
	private String bank_name;
	private String role_type;
	private String provider;
	private String providerId;
	private Timestamp create_date;
}
