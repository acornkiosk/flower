package com.acorn.flower.menu.match;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MatchDaoImpl implements MatchDao{
	@Autowired private SqlSession session;
	@Override
	public void insert(MatchDto dto) {
		session.insert("match.insert",dto);
		
	}
	@Override
	public void delete(int id) {
		session.delete("match.delete",id);
		
	}

}
