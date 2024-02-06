package com.acorn.flower.kiosk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KioskController {

	@Autowired
	private KioskService service;
	
	@GetMapping("/kiosk/index")
	public String kioskIndex(Model model) {
		List<KioskDto> list = service.getKioskList();
		model.addAttribute("list", list);
		System.out.println(list);
		return "test/kiosk/index";
	}
	
	@PostMapping("/kiosk/add")
	public String kioskAdd(KioskDto dto) {
		dto.setIs_using("false");
		System.out.println(dto);
		service.addKiosk(dto);
		return "redirect:/kiosk/index";
	}
}
