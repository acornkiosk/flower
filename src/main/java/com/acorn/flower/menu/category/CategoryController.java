package com.acorn.flower.menu.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
	@Autowired private CategoryService service;
	
	@GetMapping("/menu/category/insert_form")
	public String insertForm() {
		return "menu/category/insert_form";
	}
	
	@PostMapping("/menu/category/insert")
	public String insert(CategoryDto dto) {
		service.addCategory(dto);
		return "";
	}
}
