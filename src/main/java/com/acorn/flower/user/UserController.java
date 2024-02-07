package com.acorn.flower.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PutMapping("/api/user/update")
	public Map<String, Object> userUpdate(@RequestBody UserDto dto) {
		Map<String, Object> result = new HashMap<String, Object>();
//		service.userUpdate(dto);
		UserDto dto2 = service.getUser(dto.getPassword());

		if(dto2 != null) {
			result.put("isSuccess", true);
			result.put("dto", dto2);
		}else {
			result.put("isSuccess", false);
			result.put("dto", null);
		}
		return result;
	}

	@DeleteMapping("/api/user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable String id) {

		return ResponseEntity.ok("User with ID " + id + " has been deleted successfully.");

	}
}
