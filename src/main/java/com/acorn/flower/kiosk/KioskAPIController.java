package com.acorn.flower.kiosk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KioskAPIController {
	@Autowired
	private KioskService service;

	/**
	 * 키오스크 추가
	 * @param dto
	 * @return
	 */
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

	/**
	 * 키오스크 1개 정보 얻기
	 * @param id
	 * @return
	 */
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

	/**
	 * 키오스크 리스트 얻기
	 * @return
	 */
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

	/**
	 * 키오스크 1개 삭제하기
	 * @param id
	 * @return
	 */
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

	/**
	 * 키오스크 1개 전원 켜기
	 * @param id
	 * @return
	 */
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

	/**
	 * 키오스크 1개 전원 끄기
	 * @param id
	 * @return
	 */
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
	
	/**
	 * 키오스크 전체 전원 켜기
	 * @return
	 */
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
	
	/**
	 * 키오스크 전체 전원 끄기
	 * @return
	 */
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
	
	/**
	 * 키오스크 1개 위치 변경하기
	 * @param dto
	 * @return
	 */
	@PostMapping("/api/kiosk/updateLocation")
	public Map<String,Object> updateLocation(@RequestBody KioskDto dto){
		Map<String, Object> result = new HashMap<String, Object>();
		service.updateLocation(dto);
		KioskDto updatedDto = service.getKiosk(dto.getId());
		
		if(updatedDto == null) {
			result.put("isSuccess", false);
			result.put("dto",null);
		}else {
			if(dto.getLocation() == updatedDto.getLocation()) {
				result.put("isSuccess", false);
				result.put("dto", updatedDto);
			}else {
				result.put("isSuccess",true);
				result.put("dto", updatedDto);
			}
		}
		return result;
	}
}
