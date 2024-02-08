package com.acorn.flower.menu.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CategoryController {
	@Autowired private CategoryService service;
	/*
	@GetMapping("/menu/category/category_list")
	public String getCategoryList() {
		service.getList();
		return "menu/category/insert_form";
	}*/
	
	@ResponseBody
	@GetMapping("/menu/category/delete/{id}")
	public String DeleteCategory(@PathVariable int id) {
		service.deleteCategory(id);
		return "ok";
	}
	
	@ResponseBody
	@GetMapping("/menu/category/getCategoryList")
	public List<CategoryDto> getCategoryList(){
		return service.getList();
	}
	
	@GetMapping("/menu/category/insert_form")
	public String insertForm() {
		
		
		return "menu/category/insert_form";
	}
	
	@PostMapping("/menu/category/insert")
	public String insert(CategoryDto dto) {
		service.addCategory(dto);
		return "redirect:/menu/category/insert_form";
	}
	
}
