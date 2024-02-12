package com.acorn.flower.menu.category;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.acorn.flower.menu.MenuDao;
import com.acorn.flower.menu.MenuDto;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired private CategoryDao categoryDao;
	@Autowired private MenuDao menuDao;
	
	@Override
	public List<CategoryDto> getList() {
		return categoryDao.getList();
	};
	
	@Override
	public void addCategory(CategoryDto dto) {
		categoryDao.insert(dto);
	}

	@Override
	public void deleteCategory(int id) {
		categoryDao.delete(id);
	}

	@Override
	public CategoryDto getData(int id) {
		return categoryDao.getData(id);
	}

	@Override
	public void updateCategory(CategoryDto dto) {
		categoryDao.update(dto);
	}
	
	@Override
	public void updateMenu(MenuDto dto) {
		System.out.println("Received DTO(Service): " + dto);
		categoryDao.updateMenu(dto);
	}

};
