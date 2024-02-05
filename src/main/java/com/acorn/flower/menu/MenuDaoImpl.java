package com.acorn.flower.menu;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MenuDaoImpl implements MenuDao {
    @Autowired 
    private SqlSession session;

	@Override
	public void insert(MenuDto dto) {
		session.insert("menu.insert",dto);
		
	}
    
    
}
