package com.mysh.shareHouse.model;

import java.sql.Timestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

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
	@NotEmpty
	@Size(max = 20, message = "ID는 20자를 초과할 수 없습니다.")
	private String userName;
	@NotEmpty
	private String password;
	@Email
	@NotEmpty
	private String email;
	@NotNull
	private int phNum;
	private char gender;
	private String terms;
	@NotEmpty
	private String address;
	@NotEmpty
	private String bankName;
	private String roleType;
	private String provider;
	private String providerId;
	@PastOrPresent
	private Timestamp createDate;
}
