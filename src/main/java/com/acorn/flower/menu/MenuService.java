package com.acorn.flower.menu;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.acorn.flower.menu.category.CategoryDto;

public interface MenuService {
	public void addMenu(MenuDto dto);
	public void updateMenu(MenuDto dto);
	public void deleteMenu(int id);
	public List<MenuDto> getList();
	public MenuDto getData(int id);
	public List<MenuDto> getList(CategoryDto dto);
}
