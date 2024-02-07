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
	
	@PostMapping("/menu/categroy/insert")
	public String insert(CategoryDto dto) {
		
		return "redirect:/menu/menu_main";
	}
}
