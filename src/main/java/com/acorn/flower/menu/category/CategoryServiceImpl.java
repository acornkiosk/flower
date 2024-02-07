package com.acorn.flower.menu.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired private CategoryDao categoryDao;
	@Override
	public void addCategory(CategoryDto dto) {
		
		categoryDao.insert(dto);
	}

}
