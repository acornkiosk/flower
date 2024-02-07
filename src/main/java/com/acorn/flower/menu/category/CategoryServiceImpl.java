package com.acorn.flower.menu.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired private CategoryDao categoryDao;
	
	/** MenuController 에도 요청이 오는 메서드입니다. */
	@Override
	public void getList(Model model) {
		List<CategoryDto> categoryList = categoryDao.getList();
		model.addAttribute("list", categoryList);
	}

}
