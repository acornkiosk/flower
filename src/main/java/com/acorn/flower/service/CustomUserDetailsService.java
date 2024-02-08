package com.acorn.flower.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.acorn.flower.user.UserDao;
import com.acorn.flower.user.UserDto;



@Service
public class CustomUserDetailsService implements UserDetailsService{

		@Autowired private UserDao dao;
		
		
	//Spring Securty 가 로그인 처리시 호출하는 메소드
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		//user_id 에는 로그인폼에 입력한 user_id 전달된다
	
		//DB에 저장된 데이터를 읽어온다.
		UserDto dto=dao.getUser(id);	
		
		if(dto==null) {
			System.out.println("사용자 정보 없음");
			 throw new UsernameNotFoundException("존재하지 않는 사용자 입니다.");
			//exception 추가하기
		}
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		//DB에는 암호화 되어서 비밀번호가 저장되 어있으므로 복호화한다.
		String encodedPwd=encoder.encode(dto.getPassword());
	
		
		// 2. UserDetails 객체에 해당정보를 담아서 리턴해 주어야 한다.	
		// 권한은 1개 이지만 List에 담아서
		List<GrantedAuthority>  authList=new ArrayList<GrantedAuthority>();
		authList.add(new SimpleGrantedAuthority("ROLE_"+dto.getRank())); //ROLE_super
		//Spring Security 가 제공하는 User 클래스는 UserDetails 인터페이스를 구현한 클래스이다.
		UserDetails ud=new User(dto.getId(),encodedPwd,authList);
		
		
		return ud;
	}

}




/*
 * 
주어진 코드에서는 사용자의 비밀번호를 암호화한 후 UserDetails 객체를 생성하여 리턴하고 있습니다. 그러나 사용자 인증을 위해서는 비밀번호를 암호화된 상태로 UserDetails 객체에 설정해야 합니다.

따라서 UserDetails ud=new User(dto.getUser_id(),dto.getUser_pwd(),authList); 로 변경하는 것은 사용자의 비밀번호를 암호화하지 않은 상태로 사용자 객체를 생성하는 것입니다. 이렇게 되면 사용자가 제공한 비밀번호와 데이터베이스에 저장된 암호화된 비밀번호가 일치하지 않기 때문에 로그인이 실패합니다.

따라서 비밀번호를 암호화하여 UserDetails 객체를 생성하는 방식으로 코드를 유지해야 합니다.
 * */
