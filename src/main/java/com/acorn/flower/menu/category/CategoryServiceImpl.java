package com.acorn.flower.menu.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired private CategoryDao categoryDao;
	
	@Override
	public List<CategoryDto> getList() {
		return categoryDao.getList();
	};
	
	@Override
	public void addCategory(CategoryDto dto) {
		categoryDao.insert(dto);
	};

};
