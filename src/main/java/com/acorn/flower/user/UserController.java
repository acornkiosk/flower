package com.acorn.flower.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.acorn.flower.kiosk.KioskDto;


import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/api/user/insert")
	public ResponseEntity<String> UserInset(@RequestBody UserDto dto){
		service.userInsert(dto);
		UserDto dto2 = service.getUser(dto.getId());
		return ResponseEntity.ok("id"+ " 님의 회원가입이 성공적으로 완료되었습니다.");
	}
	
}
