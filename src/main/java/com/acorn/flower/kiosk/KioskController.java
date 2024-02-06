package com.acorn.flower.kiosk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@ResponseBody
	@GetMapping("/kiosk/turnOn")
	public Map<String, Object> kioskTurnOn(int id) {
		Map<String, Object> result = new HashMap<String, Object>();
		service.turnOn(id);
		KioskDto dto = service.getKiosk(id);
		if (dto == null) {
			result.put("isSuccess", false);
			result.put("dto", dto);
		} else {
			if (dto.getIs_using().equals("true")) {
				result.put("isSuccess", true);
				result.put("dto", dto);
			} else {
				result.put("isSuccess", false);
				result.put("dto", dto);
			}
		}

		return result;

	}
	
	@ResponseBody
	@GetMapping("/kiosk/turnOff")
	public Map<String, Object> kioskTurnOff(int id) {
		Map<String, Object> result = new HashMap<String, Object>();
		service.turnOff(id);
		KioskDto dto = service.getKiosk(id);
		if (dto == null) {
			result.put("isSuccess", false);
			result.put("dto", dto);
		} else {
			if (dto.getIs_using().equals("false")) {
				result.put("isSuccess", true);
				result.put("dto", dto);
			} else {
				result.put("isSuccess", false);
				result.put("dto", dto);
			}
		}

		return result;
	}
	
}
