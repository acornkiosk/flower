package com.acorn.flower.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * React 리팩토링 대비코드, API 활용 메뉴관리 Controller
 * <br>
 * @author "이승우", "김대원"
 * @since 2024-02-07
 * @version 0.1 / 프로젝트 버전
 */

@RestController
public class MenuApiController {
	@Autowired private MenuService service;
//	
//	//  =========== 페이지 전환 API controller (시작) ===========
//	
//	//  =========== 페이지 전환 API controller (종료) ===========
//	
//	
//	//  =========== 데이터 요청 API controller (시작) ===========
//	
//	//  =========== 데이터 요청 API controller (종료) ===========
//	
//	
//	//id 값으로 Menu(하나,Dto)를 가져오는 api
//	@GetMapping("/api/menu/{id}")
//	public Map<String,Object> getMenu(@PathVariable int id){
//		Map<String,Object> result= new HashMap<String,Object>();
//		Map<String, Object> dataMap = service.getData(id);
//		MenuDto dto = (MenuDto)dataMap.get("dto");
//		if(dto!=null) {
//			result.put("isSuccess", true);
//			result.put("dto",dto);
//		}else {
//			result.put("isSuccess",false);
//			result.put("dto", null);
//		}
//		return result;
//	}
//	
//	//map명령어 사용이유 : boolean반환값 받기 위해
//	//dataMap : 기존코드에 Model 객체가 존재했음, 근데 api 전달과정엣 문제있
//	
//	//menu의 list를 가져오는 api
//	@GetMapping("/api/menu/list")
//	public Map<String,Object> getMenuList() {
//		Map<String,Object> result= new HashMap<String,Object>();
//		List<MenuDto> list = service.getList();
//		if(list!=null) {
//			result.put("isSuccess", true);
//			result.put("list",list);
//		}else {
//			result.put("isSuccess",false);
//			result.put("list", null);
//		}
//		return result;
//	}
//	
//	
//	
//	@PostMapping("/api/addMenu")
//	public Map<String, Object> addMenu(@RequestBody MenuDto dto) {
//		Map<String,Object> result = new HashMap<String, Object>();
//		service.addMenu(dto);
//		
//		Map<String, Object> dataMap = service.getData(dto.getId());
//	
//		MenuDto dto2=(MenuDto)dataMap.get("dto");
//		if(dto2 !=null) {
//			result.put("isSuccess", true);
//			result.put("dto", dto2);
//		}else {
//			result.put("isSuccess",false);
//			result.put("dto",null);
//		}
//		
//		return result;
//	}
//	
//	@PostMapping("/api/updateMenu")
//	public String updateMenu(@RequestBody MenuDto dto) {
//		
//		service.updateMenu(dto);
//		
//		return "ok";
//	}
//	
//	@GetMapping("/api/deleteMenu/{id}")
//	public String deleteMenu(@PathVariable int id) {
//		
//		service.deleteMenu(id);
//		
//		return "ok";
//	}
//	
//	@GetMapping("/menu/update_form") // 메뉴관리 3번, 메뉴수정페이지 
//	public String updateForm(Model model, int id) {
//		Map<String, Object> dataMap = service.getData(id);
//		model.addAttribute("list",dataMap.get("list"));
//		model.addAttribute("dto",dataMap.get("dto"));
//		return "menu/update_form";
//		
//	}
//	
}
