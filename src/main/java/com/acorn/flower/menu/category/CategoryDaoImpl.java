package com.acorn.flower.menu.category;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.acorn.flower.menu.MenuDto;

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

	@Override
	public void delete(int id) {
		session.delete("category.delete",id);
		
	}

	@Override
	public CategoryDto getData(int id) {
		return session.selectOne("category.getData", id);
		
	}

	@Override
	public void update(CategoryDto dto) {
		session.update("category.update", dto);
	}

	@Override
	public void updateMenu(MenuDto dto) {
		System.out.println("Received DTO(Dao): " + dto);
		session.update("category.updateMenu", dto);
	}

	@Override
	public void updateToNull(String name) {
		session.update("category.updateToNull",name);
		
	}

	@Override
	public int menuRowCount(String name) {
		
		return session.selectOne("category.menuRowCount", name);
	}

	
	
}
