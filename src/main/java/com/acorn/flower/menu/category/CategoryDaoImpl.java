package com.acorn.flower.menu.category;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	@Autowired 
    private SqlSession session;
	
	
	
}
