package com.acorn.flower.menu.category;

import java.util.List;

import com.acorn.flower.menu.MenuDto;

public interface CategoryDao {
	public List<CategoryDto> getList();
	public void insert(CategoryDto dto);
	public void delete(int id);
	public CategoryDto getData(int id);
	public void update(CategoryDto dto);
	public void updateMenu(MenuDto dto);
	public void updateToNull(String name);// 메뉴의 카테고리를 null로..
	public int menuRowCount(String name);// 특정 카테고리를 가지고 있는 메뉴갯수 

}
