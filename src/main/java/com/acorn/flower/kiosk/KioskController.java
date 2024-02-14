package com.acorn.flower.kiosk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

	@GetMapping("/emp/kiosk/index")
	public String kioskIndex(Model model) {
		List<KioskDto> list = service.getKioskList();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null && auth.isAuthenticated()) {
	        // 인증된 사용자의 권한을 가져옴
	        String role = auth.getAuthorities().iterator().next().getAuthority();
	        // 권한에 따라 라벨을 설정
	        String roleLabel = "";
	        if (role.equals("ROLE_super")) {
	            roleLabel = "[관리자]";
	        } else if (role.equals("ROLE_owner")) {
	            roleLabel = "[사장님]";
	        } else if (role.equals("ROLE_emp")) {
	            roleLabel = "[직원]";
	        }
	        System.out.println("역할"+roleLabel);
	        // 모델에 권한 라벨 추가
	        model.addAttribute("roleLabel", roleLabel);
	    }
		
		
		model.addAttribute("list", list);
		return "/kiosk/index";
		//todo 나중에 경로 수정해야함
	}

	@PostMapping("/emp/kiosk/add")
	public String kioskAdd(KioskDto dto) {
		dto.setIs_using("false");
		service.addKiosk(dto);
		return "redirect:/emp/kiosk/index";
	}

	@GetMapping("/emp/kiosk/delete")
	public String kioskDelete(int id) {
		service.deleteKiosk(id);
		return "redirect:/emp/kiosk/index";
	}

	@ResponseBody
	@GetMapping("/emp/kiosk/turnOn")
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
	@GetMapping("/emp/kiosk/turnOff")
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

	@GetMapping("/emp/kiosk/turnOnAll")
	public String kioskTurnOnAll() {
		service.turnOnAll();
		return "redirect:/emp/kiosk/index";
	}
	
	@GetMapping("/emp/kiosk/turnOffAll")
	public String kioskTurnOffAll() {
		service.turnOffAll();
		return "redirect:/emp/kiosk/index";
	}
	
	@PostMapping("/emp/kiosk/updateLocation")
	public String kioskUpdateLocation(KioskDto dto) {
		System.out.println(dto);
		service.updateLocation(dto);
		return "redirect:/emp/kiosk/index";
	}

}
