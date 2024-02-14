package com.acorn.flower.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.acorn.flower.menu.MenuDto;
import com.acorn.flower.menu.MenuService;

@Controller
public class MainController {
	@Autowired
	private MenuService service;

	@GetMapping("/main")
	public String main(Model model) {
		List<MenuDto> list = service.getList();
		model.addAttribute("list",list);
		return "main";
	}
}
