package com.acorn.flower.menu.category;

import java.util.List;

import org.springframework.ui.Model;

import com.acorn.flower.menu.MenuDto;

public interface CategoryService {
	public List<CategoryDto> getList();
	public void addCategory(CategoryDto dto);
	public void deleteCategory(int id);
	public CategoryDto getData(int id);
	public void updateCategory(CategoryDto dto);
	public void updateMenu(MenuDto dto);
	public int menuCategoryCount(int id);

}
