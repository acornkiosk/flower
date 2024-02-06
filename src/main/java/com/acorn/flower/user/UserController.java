package com.acorn.flower.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/api/user")
	public Map<String, Object> userUpdate(UserDto dto, HttpSession session) {
		Map<String, Object> result = new HashMap<String, Object>();
//		service.userUpdate(dto);
//		
//		UserDto dto2 = service.getUser(dto.getPassword());
//		if(dto2 != null) {
//			result.put("isSuccess", true);
//			result.put("dto", dto2);
//		}else {
//			result.put("isSuccess", false);
//			result.put("dto", null);
//		}
		return result;
	}
	
	
	
	
	
	
}
