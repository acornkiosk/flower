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
		return "test/kiosk/index";
	}
	
	@PostMapping("/kiosk/add")
	public String kioskAdd(KioskDto dto) {
		dto.setIs_using("false");
		service.addKiosk(dto);
		return "redirect:/kiosk/index";
	}
	
	@GetMapping("/kiosk/delete")
	public String kioskDelete(int id) {
		service.deleteKiosk(id);
		return "redirect:/kiosk/index";
	}
}
