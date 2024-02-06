package com.acorn.flower.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService{

	
	//Spring Securty 가 로그인 처리시 호출하는 메소드
	@Override
	public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {
		//user_id 에는 로그인폼에 입력한 user_id 전달된다
		
		//DB에 저장된 데이터를 읽어온다.
			
		// 비밀번호를 암호화 하기 위한 객체
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		//DB에는 암호화 되어서 비밀번호가 저장되 어있으므로 복호화한다.
		String encodedPwd=encoder.encode("1234");
	
		
		// 2. UserDetails 객체에 해당정보를 담아서 리턴해 주어야 한다.
		// 권한은 1개 이지만 List에 담아서
		List<GrantedAuthority>  authList=new ArrayList<GrantedAuthority>();
		authList.add(new SimpleGrantedAuthority("ROLE_EMP"));
		
		//Spring Security 가 제공하는 User 클래스는 UserDetails 인터페이스를 구현한 클래스이다.
		UserDetails ud=new User(user_id,encodedPwd,authList);
		
		
		return ud;
	}

}





