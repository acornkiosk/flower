package com.acorn.flower.user;

import org.springframework.ui.Model;

public interface UserService {
	public void addUser(UserDto dto);
	public void getInfo(Model model);
	public void updateUser(UserDto dto);
	public void updatePassword(UserDto dto);
<<<<<<< Updated upstream
	public UserDto getUser(UserDto dto);
	public UserDto userInsert(UserDto dto);
	UserDto getUser(String id);
=======
	public void userUpdate(UserDto dto);
	public UserDto getUser(UserDto dto);
	UserDto getUser(String password);
>>>>>>> Stashed changes
}
