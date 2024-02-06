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

/**
 * React 리팩토링 전 코드, Thymeleaf 전용 메뉴관리 Controller
 * <br>
 * @author "이승우", "김대원"
 * @since 2024-02-05
 * @version 0.1 / 프로젝트 버전(본인이 임의로) 
 */

@Controller
public class MenuController {
	@Autowired private MenuService service;
	
	
	@GetMapping("/menu/detail")
	public String detail(Model model,int id) {
		Map<String, Object> dataMap = service.getData(id);
		model.addAttribute("dto",(MenuDto)dataMap.get("dto"));
	
		return "menu/detail";
	}
	

	@GetMapping("/menu/menu_main")
	public String MainMenu(Model model) { // 메뉴관리 1번, 관리통합페이지 
		List<MenuDto> list=service.getList();
		model.addAttribute("list",list);
		return "menu/menu_main";
	}
	
	@GetMapping("/menu/insert_form") // 메뉴관리 2번, 메뉴추가페이지 
	public String insertForm() {
		
		return "menu/insert_form";
	}
	
	
	@PostMapping("/menu/insert")// 메뉴관리 2-1 
	public String insert(MenuDto dto) {
		service.addMenu(dto);
		return "redirect:/menu/menu_main";
	}

	@GetMapping("/menu/update_form") // 메뉴관리 3번, 메뉴수정페이지 
	public String updateForm(Model model, int id) {
		Map<String, Object> dataMap = service.getData(id);
		model.addAttribute("list",dataMap.get("list"));
		model.addAttribute("dto",dataMap.get("dto"));
		return "menu/update_form";
		
	}
	/*
	@GetMapping("/menu/update_form") // 메뉴관리 3번, 메뉴수정페이지 
	public String updateForm(Model model, int id) {
		service.getData(id);
		return "menu/update_form";
		
	}*/
	

	@PostMapping("/menu/update")// 메뉴관리 3-1 
	public String updateMenu(MenuDto dto) {
		
		service.updateMenu(dto);
		
		return "menu/update"; // todo : 이것도 redirect 코드로 수정필요 
	}
	
	@GetMapping("/menu/delete")
	public String deleteMenu(int id) {
		
		service.deleteMenu(id);
		
		return "menu/delete";
	}

	
}
