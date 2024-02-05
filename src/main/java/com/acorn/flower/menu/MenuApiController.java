package com.acorn.flower.menu;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * React 리팩토링 대비코드, API 활용 메뉴관리 Controller
 * <br>
 * @author "이승우", "김대원"
 * @since 2024-02-05
 * @version 0.1 / 프로젝트 버전(본인이 임의로) 
 */

@RestController
public class MenuApiController {
	@Autowired private MenuService service;
	
	@PostMapping("/api/addMenu")
	public String addMenu(@RequestBody MenuDto dto) {
		
		service.addMenu(dto);
		return "ok";
	}
	
	@PostMapping("/api/updateMenu")
	public String updateMenu(@RequestBody MenuDto dto) {
		
		service.updateMenu(dto);
		
		return "ok";
	}
	
	@GetMapping("/api/deleteMenu/{id}")
	public String deleteMenu(@PathVariable int id) {
		
		service.deleteMenu(id);
		
		return "ok";
	}
	
}
