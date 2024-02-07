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

	@GetMapping("/super/kiosk/index")
	public String kioskIndex(Model model) {
		List<KioskDto> list = service.getKioskList();
		model.addAttribute("list", list);
		return "test/kiosk/index";
		//todo 나중에 경로 수정해야함
	}

	@PostMapping("/super/kiosk/add")
	public String kioskAdd(KioskDto dto) {
		dto.setIs_using("false");
		service.addKiosk(dto);
		return "redirect:/super/kiosk/index";
	}

	@GetMapping("/super/kiosk/delete")
	public String kioskDelete(int id) {
		service.deleteKiosk(id);
		return "redirect:/super/kiosk/index";
	}

	@ResponseBody
	@GetMapping("/super/kiosk/turnOn")
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
	@GetMapping("/super/kiosk/turnOff")
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

	@GetMapping("/super/kiosk/turnOnAll")
	public String kioskTurnOnAll() {
		service.turnOnAll();
		return "redirect:/super/kiosk/index";
	}
	
	@GetMapping("/super/kiosk/turnOffAll")
	public String kioskTurnOffAll() {
		service.turnOffAll();
		return "redirect:/super/kiosk/index";
	}
	
	@PostMapping("/super/kiosk/updateLocation")
	public String kioskUpdateLocation(KioskDto dto) {
		service.updateLocation(dto);
		return "redirect:/super/kiosk/index";
	}

}
