package com.acorn.flower.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 사용자
 */
@RestController
public class UserAPIController {
	@Autowired
	private UserService service;
	/**
	 * 사용자 추가
	 * @param dto
	 * @return
	 */
	@PostMapping("/api/user/insert")
	public Map<String, Object> insertUser(@RequestBody UserDto dto){
		Map<String, Object> result = new HashMap<String, Object>();
		service.insertUser(dto);
		UserDto dto2 = service.getUser(dto.getId());
		if(dto2 != null) {
			result.put("isSuccess", true);
			result.put("dto", dto2);
		}else {
			result.put("isSuccess", false);
			result.put("dto", null);
		}
		
		return result;
	}
	
	/**
	 * 사용자 정보 업데이트(ID는 제외)
	 * @param dto
	 * @return
	 */
	@PostMapping("/api/user/update") 
	public Map<String, Object> updateUser(@RequestBody UserDto dto) { 
		Map<String, Object> result = new HashMap<String, Object>();
		service.updateUser(dto);
		UserDto dto2 = service.getUser(dto.getId());
		if(dto2 != null) {
			result.put("isSuccess", true);
			result.put("dto", dto2);
		}else {
			result.put("isSuccess", false);
			result.put("dto", null);
		}
		return result;
	}
	
	/**
	 * 사용자 정보 삭제
	 * @param id
	 * @return
	 */
	@DeleteMapping("/api/user/{id}")
	public Map<String, Object> deleteUser(@PathVariable String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		service.deleteUser(id);
		UserDto dto = service.getUser(id);
		if(dto == null) {
			result.put("isSuccess", true);
		}else {
			result.put("isSuccess", false);
		}
		return result;
	}
	
	/**
	 * 사용자 전체정보 얻어오기
	 * @return
	 */
	@GetMapping("/api/user/list")
	public Map<String, Object> getUserList(){
		Map<String, Object> result = new HashMap<String, Object>();
		List<UserDto> list = service.getUserList();
		if(list != null) {
			result.put("isSuccess", true);
			result.put("list", list);
		}else {
			result.put("isSuccess", false);
			result.put("list", null);
		}
		
		return result;
	}

}
