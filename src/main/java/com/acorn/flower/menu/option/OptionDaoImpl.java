package com.acorn.flower.menu.option;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OptionDaoImpl implements OptionDao {
	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(OptionDto dto) {
		session.insert("option.insert",dto);
	}

}
