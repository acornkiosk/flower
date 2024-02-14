package com.acorn.flower.menu.set;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.acorn.flower.menu.MenuDto;
import com.acorn.flower.menu.MenuService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
public class SetController {
	@Autowired MenuService menu;
	
	/** 세트로 설정할 메뉴정보 가져오기 */
	@GetMapping("/menu/set/setting_form")
	public String getSetMenu(Model model, int id) {
		MenuDto dto = menu.getData(id);
		List<MenuDto> menuList = menu.getList();
		model.addAttribute("dto", dto);
		model.addAttribute("list", menuList);
		return "menu/set/setting_form";
	}
	
	
}
