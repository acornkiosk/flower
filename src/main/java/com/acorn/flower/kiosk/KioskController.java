package com.acorn.flower.kiosk;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
public class KioskController {
	@Autowired
	private KioskService service;
	
	@PostMapping("/api/kiosk")
	public String postKiosk(@RequestBody Map<String,String> queryParaMap) {
		KioskDto dto = new KioskDto();
		dto.setLocation(queryParaMap.get("location"));
		dto.setIsUsing(queryParaMap.get("isUsing"));
		service.addKiosk(dto);
		return "OK";
	}	
}
