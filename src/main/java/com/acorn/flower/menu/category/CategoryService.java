package com.acorn.flower.menu.category;

import org.springframework.ui.Model;

public interface CategoryService {
	public void getList(Model model);
	public void addCategory(CategoryDto dto);
}
