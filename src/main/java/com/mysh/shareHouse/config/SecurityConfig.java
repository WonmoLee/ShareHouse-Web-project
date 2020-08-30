package com.mysh.shareHouse.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.mysh.shareHouse.config.oauth.PrincipalOauth2UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private static final Logger log = LoggerFactory.getLogger(SecurityConfig.class);
	
	@Autowired
	private PrincipalOauth2UserService	principalOauth2UserService;
	
	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/myPage/**").authenticated()
			.antMatchers("/adminPage/**").access("hasAnyAuthority('ADMIN') or hasAnyAuthority('MANAGER')")
			.anyRequest().permitAll()
		.and()
			.formLogin()
			.loginPage("/loginOrSignup")
			.loginProcessingUrl("/loginProc")
			.defaultSuccessUrl("/loginResp")
			.failureHandler(new AuthenticationFailureHandler() {		
				@Override 
				public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
						AuthenticationException exception) throws IOException, ServletException {
					response.setContentType("text/html; charset=utf-8"); 
					log.info("아이디 또는 패스워드가 일치하지 않음");
					return ;
				}
			})
		.and()	
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/")
		.and()
			.oauth2Login()
			.loginPage("/loginOrSignup")
			.userInfoEndpoint()
			.userService(principalOauth2UserService);
		
	}
}
