package com.acorn.flower.menu;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.acorn.flower.menu.category.CategoryDto;
import com.acorn.flower.menu.category.CategoryService;

/**
 * React 리팩토링 전 코드, Thymeleaf 전용 메뉴관리 Controller
 * <br>
 * 페이지 이동과 데이터 처리로 구분됩니다.
 * <br>
 * API 요청이 아니기에 Model 객체를 service 에 전달하여 데이터를 요청처리합니다. 
 * <br>
 * @author "이승우", "김대원"
 * @since 2024-02-07
 * @version 0.1 / 프로젝트 버전
 */

@Controller
public class MenuController {
	@Autowired private MenuService menuService;
	@Autowired private CategoryService categoryService;
	
	/** 1.관리통합페이지 */
	@GetMapping("/menu/menu_main")
	public String MainMenu(Model model) {
	List<MenuDto> menuList = menuService.getList();
	model.addAttribute("list", menuList);
		return "menu/menu_main";
	}
	
	/** 2.메뉴등록페이지  */
	@GetMapping("/menu/insert_form")
	public String insertForm(Model model) {
		List<CategoryDto> categoryList = categoryService.getList();
		model.addAttribute("list", categoryList);
		return "menu/insert_form";
	}
	
	/** 3.메뉴수정페이지 */
	@GetMapping("/menu/update_form")
	public String updateForm(Model model, int id) {
		MenuDto dto = menuService.getData(id);
		List<CategoryDto> categoryList = categoryService.getList();
		model.addAttribute("dto", dto);
		model.addAttribute("list", categoryList);
		return "menu/update_form";
	}
	
	/** 페이지 이동 4번.메뉴상세페이지 */
	@GetMapping("/menu/detail")
	public String detail(Model model,int id) {
		MenuDto dto = menuService.getData(id);
		// List<CategoryDto> categoryList = categoryService.getList();
		model.addAttribute("dto", dto);
		// model.addAttribute("list", categoryList);
		return "menu/detail";
	}

	/** 데이터 조작 : 등록 */
	@PostMapping("/menu/insert")
	public String insert(MenuDto dto) {
		menuService.addMenu(dto);
		return "redirect:/menu/menu_main";
	}

	/** 데이터 조작 : 수정 */
	@PostMapping("/menu/update")
	public String updateMenu(MenuDto dto) {
		menuService.updateMenu(dto);
		return "menu/update";
	}
	
	/** 데이터 조작 : 삭제 */
	@GetMapping("/menu/delete")
	public String deleteMenu(int id) {
		menuService.deleteMenu(id);
		return "menu/delete";
	}
	
} // class 
