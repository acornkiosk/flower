package com.acorn.flower.kiosk;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KioskAPIController {
	@Autowired
	private KioskService service;

	@PostMapping("/api/kiosk")
	public Map<String, Object> addKiosk(@RequestBody KioskDto dto) {
		Map<String, Object> result = new HashMap<String, Object>();
		service.addKiosk(dto);
		KioskDto dto2 = service.getKiosk(dto.getId());
		if (dto2 != null) {
			result.put("isSuccess", true);
			result.put("dto", dto2);
		} else {
			result.put("isSuccess", false);
			result.put("dto", null);
		}

		return result;
	}

	@GetMapping("/api/kiosk/{id}")
	public Map<String, Object> getKiosk(@PathVariable int id) {
		Map<String, Object> result = new HashMap<String, Object>();
		KioskDto dto = service.getKiosk(id);
		if (dto != null) {
			result.put("isSuccess", true);
			result.put("dto", dto);
		} else {
			result.put("isSuccess", false);
			result.put("dto", null);
		}

		return result;
	}

	@GetMapping("/api/kiosk/list")
	public Map<String, Object> getKioskList() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<KioskDto> list = service.getKioskList();
		if (list != null) {
			result.put("isSuccess", true);
			result.put("list", list);
		} else {
			result.put("isSuccess", false);
			result.put("list", null);
		}

		return result;
	}

	@DeleteMapping("/api/kiosk/{id}")
	public Map<String, Object> deleteKiosk(@PathVariable int id) {
		Map<String, Object> result = new HashMap<String, Object>();
		service.deleteKiosk(id);
		KioskDto dto = service.getKiosk(id);
		if (dto == null) {
			result.put("isSuccess", true);
		} else {
			result.put("isSuccess", false);
		}

		return result;

	}

	@PostMapping("/api/kiosk/turnOn/{id}")
	public Map<String, Object> turnOnKiosk(@PathVariable int id) {
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

	@PostMapping("/api/kiosk/turnOff/{id}")
	public Map<String, Object> turnOffKiosk(@PathVariable int id) {
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
	
	@PostMapping("/api/kiosk/turnOnAll")
	public Map<String,Object> turnOnAll(){
		Map<String, Object> result = new HashMap<String, Object>();
		service.turnOnAll();
		List<KioskDto> list = service.getKioskList();
		if (list == null) {
			result.put("isSuccess", false);
			result.put("list", null);
		} else {
			int count = 0;
			for(KioskDto dto : list) {
				if(dto.getIs_using().equals("true")) {
					count++;
				}
			}
			
			if(count == list.size()) {
				result.put("isSuccess", true);
				result.put("list", list);
			}else {
				result.put("isSuccess", false);
				result.put("list", list);
			}
		}

		return result;
	}
	
	@PostMapping("/api/kiosk/turnOffAll")
	public Map<String,Object> turnOffAll(){
		Map<String, Object> result = new HashMap<String, Object>();
		service.turnOffAll();
		List<KioskDto> list = service.getKioskList();
		if (list == null) {
			result.put("isSuccess", false);
			result.put("list", null);
		} else {
			int count = 0;
			for(KioskDto dto : list) {
				if(dto.getIs_using().equals("false")) {
					count++;
				}
			}
			
			if(count == list.size()) {
				result.put("isSuccess", true);
				result.put("list", list);
			}else {
				result.put("isSuccess", false);
				result.put("list", list);
			}
		}

		return result;
	}
}
