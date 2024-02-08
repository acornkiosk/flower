package com.acorn.flower.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.flower.kiosk.KioskDto;
import com.acorn.flower.menu.category.CategoryDto;
import com.acorn.flower.menu.category.CategoryService;

/**
 * React 리팩토링 대비코드, API 활용 메뉴관리 Controller <br>
 * 
 * [ Restful API 요청 예시 ]<br><br>
 * 
 * GET    /posts 	=> post 목록 얻어오기		<br>
 * GET    /posts/1  => post 한개 얻어오기		<br>
 * POST   /posts    => post 추가 하기			<br>
 * PUT    /posts/1  => post 전체 수정 하기		<br>
 * PATCH  /posts/1  => post 일부 수정하기		<br>
 * DELETE /posts/1  => post 삭제 하기 			<br>
 * 
 * @author "이승우", "김대원"
 * @since 2024-02-07
 * @version 0.1 / 프로젝트 버전
 */

//@RestController
//public class MenuApiController {
//	@Autowired
//	private MenuService menuService;
//	@Autowired
//	private CategoryService categoryService;
//
//	
//	/** Select : get_categoryList */
//	@GetMapping("api/menu/categoryList")
//	public Map<String, Object> getCategoryList() {
//		Map<String, Object> result = new HashMap<String, Object>();
//		List<CategoryDto> list = categoryService.getList();
//		
//		if(list != null) {
//			result.put("isSuccess", true);
//			result.put("list", list);
//		} else { 
//			result.put("isSuccess", false);
//			result.put("list", list);
//		}
//		return result;
//	}
//	/** Select : get_menuList */
//	@GetMapping("api/menu/menuList")
//	public Map<String, Object> getMenuList(){
//		Map<String, Object> result = new HashMap<String, Object>();
//		List<MenuDto> list = menuService.getList();
//		
//		if(list != null) {
//			result.put("isSuccess", true);
//			result.put("list", list);
//		} else { 
//			result.put("isSuccess", false);
//			result.put("list", null);
//		}
//		return result;
//	}
//	/** Select : get_menu */
//	@GetMapping("api/menu/getMenu/{id}")
//	public Map<String, Object> getMenu(@PathVariable int id) {
//		Map<String, Object> result = new HashMap<String, Object>();
//		MenuDto dto = menuService.getData(id);
//		
//		if(dto != null) {
//			result.put("isSuccess", true);
//			result.put("dto", dto);
//		} else {
//			result.put("isSuccess", false);
//			result.put("dto", null);
//		}
//		return result;
//	}
//
//	/** Insert : insert_menu */
//	@PostMapping("api/menu/insert")
//	public void insertMenu(@RequestBody MenuDto dto){
//		menuService.addMenu(dto);
//	}
//	/** Update : update_menu */
//	@PatchMapping("api/menu/update")
//	public void updateMenu(@RequestBody MenuDto dto) {
//		menuService.updateMenu(dto);
//	}
//	/** Delete : delete_menu */
//	@DeleteMapping("api/menu/delete/{id}")
//	public void deleteMenu(@PathVariable int id) {
//		menuService.deleteMenu(id);
//	}
//	
//}
