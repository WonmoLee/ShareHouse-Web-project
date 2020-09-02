package com.mysh.shareHouse.aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.mysh.shareHouse.controller.StatusCode;
import com.mysh.shareHouse.controller.dto.CommonRespDto;

import lombok.RequiredArgsConstructor;


@Component
@Aspect
@RequiredArgsConstructor
public class BindingAdvice {

	private static final Logger log = LoggerFactory.getLogger(BindingAdvice.class);

	@Before("execution(* com.mysh.shareHouse.controller.AuthController.*(..))")
	public void auth() {
		System.out.println("AuthController에 오신 것을 환영합니다.");
	}

	@After("execution(* com.mysh.shareHouse.controller.AuthController.*(..))")
	public void auth2() {
		System.out.println();
		System.out.println("AuthController를 이용해주셔서 감사합니다.");
	}

	@SuppressWarnings("rawtypes")
	@Around("execution(* com.mysh.shareHouse.controller..*Controller.*(..))")
	public Object validationHandler(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

		String type = proceedingJoinPoint.getSignature().getDeclaringTypeName();
		String method = proceedingJoinPoint.getSignature().getName();
		
		log.info("컨트롤러 : " + type);
		log.info("URL매핑 : " + method);
		
		Object[] args = proceedingJoinPoint.getArgs();

		
		for(Object arg : args) {

			if(arg instanceof BindingResult) {
				BindingResult bindingResult = (BindingResult) arg;

				log.info("바인딩결과 : " + bindingResult);
				
				if(bindingResult.hasErrors()) {

					Map<String, String> errorMap = new HashMap<>();

					for(FieldError error : bindingResult.getFieldErrors()) {
						errorMap.put(error.getField(), error.getDefaultMessage());
					}
					
					log.info("에러내용 : " + errorMap);

					CommonRespDto<?> respDto = CommonRespDto.builder()
							.statusCode(StatusCode.FAIL)
							.message("요청에 실패하였습니다.")
							.data(errorMap)
							.build();

					return new ResponseEntity<CommonRespDto>(respDto, HttpStatus.BAD_REQUEST);
				} 
			} 
		} 
		return proceedingJoinPoint.proceed();
	}
} 

