package com.acorn.flower.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.acorn.flower.service.CustomUserDetailsService;

@Configuration //설정 클래스라는 것을 알려준다.
@EnableWebSecurity //Security 를 설정하기 위한 이노테이션
public class SecurityConfig {
	
	@Autowired private CustomUserDetailsService cud;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity hs) throws Exception{
		
		String[] whiteList= {"/",
				"/user_form",
				"/user/login_form","/user/fail",
				"/api/**", 
				"/menu/**",
				"/upload/**",
				"/test/**","/css/**","/img/**","/js/**","/scss/**","/vendor/**",
				"/swagger","/api-docs"};

		
		hs.csrf(csrf->csrf.disable()); // spring security 기본 설정인 CSRF를 비활성화 
		hs.authorizeHttpRequests(config->
			config
			.requestMatchers(whiteList).permitAll() //whiteList 요청은 로그인과 상관없이 모두 허용
			.requestMatchers("/super/**").hasRole("super") //슈퍼계정
			.requestMatchers("/owner/**").hasAnyRole("owner","super")  //사장
			.requestMatchers("/emp/**").hasAnyRole("owner","emp","super")  //사장+사원
			.anyRequest().authenticated()
		)

		.formLogin(config->
			config	
			.loginPage("/user/login_form")
			.loginProcessingUrl("/user/login") //security가 경로를 알 수 있게 경로 처리해준다.
			.usernameParameter("id")
			.passwordParameter("password")
			.successHandler(new AuthSuccessHandler()) //로그인 성공시 핸들러
			.failureForwardUrl("/user/fail") //로그인 실패경로
			.permitAll() //위에 명시한 모든 여청겨로를 로그인 없이 요청할수 있도록 설정
		)

		.logout(config->
			config
				.logoutUrl("/user/logout")  
				.logoutSuccessUrl("/") //로그아웃 성공시
				.permitAll() 
		)
		.exceptionHandling(config->
			config
				.accessDeniedPage("/user/roleFail") //권한에 맞지 않는 경로 요청시 이동시킬 경로
		);

		return hs.build();
	}
	
	//비밀번호를 암호화 해주는 객체를 bean으로 ㅅ만든다
	@Bean
	PasswordEncoder pe() {
		return new BCryptPasswordEncoder();
	}

	//인증 매니저 객체를 xbean 으로 만든다 (s s 가 자동 로그인 처리할떄도 사용되는 객체
	@Bean
	AuthenticationManager am(HttpSecurity http,
			BCryptPasswordEncoder bcryptPasswordEncoder,UserDetailsService userDetailsService) throws Exception{
		
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDetailsService)
				.passwordEncoder(bcryptPasswordEncoder)
				.and()
				.build();
		
	}

}