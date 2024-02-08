package com.acorn.flower.user;

import java.util.List;

import org.springframework.ui.Model;

public interface UserService {
	public void insertUser(UserDto dto);
	public void updateUser(UserDto dto);
	public void deleteUser(String id); 
	public UserDto getUser(String id);
	public List<UserDto> getUserList();
}
