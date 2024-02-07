package com.acorn.flower.login;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl implements LoginDao{

	@Autowired private SqlSession session;
	
	@Override
	public LoginDto getData(String user_id) {
		
		return session.selectOne("login.getData",user_id);
	}

}
