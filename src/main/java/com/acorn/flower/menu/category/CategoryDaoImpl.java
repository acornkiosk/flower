package com.acorn.flower.menu.category;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	@Autowired 
    private SqlSession session;

	@Override
	public List<CategoryDto> getList() {
		return session.selectList("category.getList");
	}

	@Override
	public void insert(CategoryDto dto) {
		session.insert("category.insert",dto);
		
	}
	
}
