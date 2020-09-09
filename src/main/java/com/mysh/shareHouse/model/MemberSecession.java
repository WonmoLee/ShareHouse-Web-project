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
public class MemberSecession {
	private int id;
	private int userId;
	private String username;
	private String phone_number;
	private Timestamp create_date;
}
