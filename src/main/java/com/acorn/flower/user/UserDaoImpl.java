package com.acorn.flower.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SqlSession session;

	@Override
	public void insert(UserDto dto) {
		session.insert("user.insert", dto);
		
	}

	@Override
	public void update(UserDto dto) {
		session.delete("user.update", dto);
		
	}

	@Override
	public void delete(String id) {
		session.delete("user.delete", id);
		
	}

	@Override
	public UserDto getUser(String id) {
		return session.selectOne("user.getUser", id);
	}

	@Override
	public List<UserDto> getUserList() {
		return session.selectList("user.getUserList");
	}
	
	

}
