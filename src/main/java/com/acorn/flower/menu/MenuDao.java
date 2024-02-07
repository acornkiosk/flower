package com.acorn.flower.menu;

import java.util.List;

import com.acorn.flower.menu.category.CategoryDto;

public interface MenuDao {
	public void insert(MenuDto dto);
	public void update(MenuDto dto);
	public void delete(int id);
	public List<MenuDto> getList();
	public MenuDto getData(int id);
}
