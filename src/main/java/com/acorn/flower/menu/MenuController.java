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
 * 페이지 이동과 데이터 처리로 구분됨
 * <br>
 * @author "이승우", "김대원"
 * @since 2024-02-05
 * @version 0.1 / 프로젝트 버전(본인이 임의로) 
 */

@Controller
public class MenuController {
	@Autowired private MenuService service;
	
	/** 1.관리통합페이지 */
	@GetMapping("/menu/menu_main")
	public String MainMenu(Model model) {
		List<MenuDto> list=service.getList();
		model.addAttribute("list",list);
		return "menu/menu_main";
	}
	
	/** 2.메뉴등록페이지  */
	@GetMapping("/menu/insert_form")
	public String insertForm() {
		return "menu/insert_form";
	}
	
	/** 3.메뉴수정페이지  */
	@GetMapping("/menu/update_form")
	public String updateForm(Model model, int id) {
		service.getData(id);
		return "menu/update_form";
		
	}
	
	/** 페이지 이동 4번.메뉴상세페이지  
	 * todo : service 구간 수정 후 현 코드 수정필요 
	 * */
	@GetMapping("/menu/detail")
	public String detail(Model model,int id) {
		Map<String, Object> dataMap = service.getData(id);
		model.addAttribute("dto",(MenuDto)dataMap.get("dto"));
	
		return "menu/detail";
	}

	/** 데이터 조작 : 등록 */
	@PostMapping("/menu/insert")
	public String insert(MenuDto dto) {
		service.addMenu(dto);
		return "redirect:/menu/menu_main";
	}

	/** 데이터 조작 : 수정 */
	@PostMapping("/menu/update")
	public String updateMenu(MenuDto dto) {
		service.updateMenu(dto);
		return "menu/update"; // todo : 이것도 redirect 코드로 수정필요 
	}
	
	/** 데이터 조작 : 삭제 */
	@GetMapping("/menu/delete") // 
	public String deleteMenu(int id) {
		
		service.deleteMenu(id);
		
		return "menu/delete";
	}
	
} // class 
