package com.acorn.flower.menu.category;

import java.util.List;

public interface CategoryDao {
	public List<CategoryDto> getList();
	public void insert(CategoryDto dto);
	public void delete(int id);
	public CategoryDto getData(int id);
}
