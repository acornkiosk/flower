package com.acorn.flower.user;

import org.springframework.ui.Model;

public interface UserService {
	public void addUser(UserDto dto);
	public void getInfo(Model model);
	public void updateUser(UserDto dto);
	public void updatePassword(UserDto dto);
}
