package com.acorn.flower.menu;

import java.util.List;

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

	@Override
	public void update(MenuDto dto) {
		session.update("menu.update", dto);
		
	}

	@Override
	public void delete(int id) {
		session.delete("menu.delete", id);
		
	}

	@Override
	public List<MenuDto> getList() {
		return session.selectList("menu.getList");
	}
		
	@Override
	public MenuDto getData(int id) {
		return session.selectOne("menu.getData", id);
	}

	@Override
	public List<CategoryDto> getDataCategory() {
		return session.selectList("menu.categoryList");
	}
    
    
}
