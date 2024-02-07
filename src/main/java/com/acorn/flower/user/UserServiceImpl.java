package com.acorn.flower.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao	dao;
	
	@Override
	public void insertUser(UserDto dto) {
		dao.insert(dto);
	}
	@Override
	public void updateUser(UserDto dto) {
		dao.update(dto);
	}
	@Override
	public void deleteUser(String id) {
		dao.delete(id);
	}
	@Override
	public UserDto getUser(String id) {
		return dao.getUser(id);
	}
	@Override
	public List<UserDto> getUserList() {
		return dao.getUserList();
	}

	
}
