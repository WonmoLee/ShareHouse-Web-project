package com.mysh.shareHouse.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mysh.shareHouse.config.oauth.PrincipalOauth2UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

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
			.antMatchers("/adminPage/**").access("hasRole('ADMIN')")
			.anyRequest().permitAll()
		.and()
			.formLogin()
			.loginPage("/loginOrSignup")
			.loginProcessingUrl("/loginProc")
			.defaultSuccessUrl("/")
		.and()	
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/loginOrSignup")
		.and()
			.oauth2Login()
			.loginPage("/loginOrSignup")
			.userInfoEndpoint()
			.userService(principalOauth2UserService);
		
	}
}
