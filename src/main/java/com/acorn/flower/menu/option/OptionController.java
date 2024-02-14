package com.acorn.flower.menu.option;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.acorn.flower.menu.category.CategoryDto;
import com.acorn.flower.menu.category.CategoryService;

@Controller
public class OptionController {
	@Autowired private CategoryService categoryService;

	@Autowired
	private OptionService service;
	
	@GetMapping("menu/option/insert_form")
	public String insertForm(Model model) {
		List<CategoryDto> categoryList = categoryService.getList();
		model.addAttribute("list", categoryList);
		return "menu/option/insert_form";
	}
	
	
	@PostMapping("/menu/option/insert")
	public String insertOption(OptionDto dto) {
		
		service.addOption(dto);
		return "menu/option/insert_form";
	}
}
