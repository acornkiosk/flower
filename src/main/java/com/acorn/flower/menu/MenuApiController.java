package com.acorn.flower.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MenuApiController {
	@Autowired private MenuService service;
	
	@PostMapping("/api/addMenu")
	public String addMenu(@RequestBody MenuDto dto) {
		
		service.addMenu(dto);
		return "ok";
	}
	
}
