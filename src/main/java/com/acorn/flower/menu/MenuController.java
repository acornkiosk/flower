package com.acorn.flower.menu;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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


	@PostMapping("/menu/update")
	public String updateMenu(MenuDto dto) {
		
		service.updateMenu(dto);
		
		return "menu/update";
	}

	
	@GetMapping("/menu/menu_main")
	public String MainMenu() {
		
		return "menu/menu_main";
	}
	
	@GetMapping("/menu/insert_form")
	public String insertForm() {
		
		return "menu/insert_form";
	}
	
	@PostMapping("/menu/insert")
	public String insert(MenuDto dto) {
		service.addMenu(dto);
		return "menu/menu_main";
	}
	
	
	

	
	@GetMapping("/menu/delete")
	public String deleteMenu(int id) {
		
		service.deleteMenu(id);
		
		return "menu/delete";
	}
}
