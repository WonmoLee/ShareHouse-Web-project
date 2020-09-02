package com.mysh.shareHouse.controller.dto;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonRespDto<T> {
	private int statusCode; //1 정상 , -1 실패 , 0변경안됨
	private String message; // 상태 메시지
	private T data;
}