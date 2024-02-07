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

import com.acorn.flower.menu.category.CategoryDto;
import com.acorn.flower.menu.category.CategoryService;

/**
 * React 리팩토링 대비코드, API 활용 메뉴관리 Controller <br>
 * 
 * @author "이승우", "김대원"
 * @since 2024-02-07
 * @version 0.1 / 프로젝트 버전
 */

@RestController
public class MenuApiController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private CategoryService categoryService;

	/** 1.관리통합페이지 */
	@GetMapping("/api/menu/menu_main")
	public Map<String, Object> MainMenu() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<MenuDto> list = menuService.getList();
		if (list != null) {
			result.put("isSuccess", true);
			result.put("list", list);
		} else {
			result.put("isSuccess", false);
			result.put("list", null);
		}
		return result;
	}

	/** 2.메뉴등록페이지 */
	@GetMapping("api/menu/insert_form")
	public Map<String, Object> insertForm() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<CategoryDto> categoryList = categoryService.getList();
		if (categoryList != null) {
			result.put("isSuccess", true);
			result.put("list", categoryList);
		} else {
			result.put("isSuccess", false);
			result.put("list", null);
		}
		return result;
	}

	/** 3.메뉴수정페이지 */
	@GetMapping("api/menu/update_form")
	public Map<String, Object> updateForm(int id) {
		MenuDto dto = menuService.getData(id);
		List<CategoryDto> categoryList = categoryService.getList();
		Map<String, Object> result = new HashMap<String, Object>();
		if (categoryList != null && dto != null) {
			result.put("isSuccess", true);
			result.put("dto", dto);
			result.put("categoryList", categoryList);
		} else if (dto == null) {
			result.put("isSuccess", false);
			result.put("dto", "메뉴정보가 없잖아");
			result.put("categoryList", null);
		} else {
			result.put("isSuccess", false);
			result.put("dto", "메뉴정보가 없잖아");
			result.put("categoryList", "카테고리DB 확인해봐");
		}
		return result;
	}

	/** 4번.메뉴상세페이지 */
	@GetMapping("api/menu/detail")
	public Map<String, Object> detail(int id) {
		MenuDto dto = menuService.getData(id);
		List<CategoryDto> categoryList = categoryService.getList();
		Map<String, Object> result = new HashMap<String, Object>();
		if (categoryList != null && dto != null) {
			result.put("isSuccess", true);
			result.put("dto", dto);
			result.put("categoryList", categoryList);
		} else if (dto == null) {
			result.put("isSuccess", false);
			result.put("dto", "메뉴정보가 없잖아");
			result.put("categoryList", null);
		} else {
			result.put("isSuccess", false);
			result.put("dto", "메뉴정보가 없잖아");
			result.put("categoryList", "카테고리DB 확인해봐");
		}
		return result;
	}
	
	/** 카테고리 항목들 가져오기 */
	@GetMapping("api/menu/category/getCategoryList")
	public List<CategoryDto> getCategoryList() {
		return categoryService.getList();
	}

//	/** 데이터 조작 : 등록 */
//	@PostMapping("api/menu/insert")
//	public Map<String, Object> insert(@RequestBody MenuDto dto) {
//		Map<String, Object> result = new HashMap<String, Object>();
//		menuService.addMenu(dto);
//		
//		return dto;
//	}

	/** 데이터 조작 : 수정 */
	@PostMapping("api/menu/update")
	public Map<String, Object> updateMenu(@RequestBody MenuDto dto) {
		Map<String, Object> result = new HashMap<String, Object>();
		menuService.updateMenu(dto);
		MenuDto newDto = menuService.getData(dto.getId());
		if (newDto == null) {
			result.put("isSuccess", true);
			result.put("dto", newDto);
		} else {
			result.put("isSuccess", false);
			result.put("dto", null);
		}
		return result;
	}

	/** 데이터 조작 : 삭제 */
	@GetMapping("api/menu/delete/")
	public Map<String, Object> deleteMenu(int id) {
		Map<String, Object> result = new HashMap<String, Object>();
		menuService.deleteMenu(id);
		MenuDto dto = menuService.getData(id);
		if (dto == null) {
			result.put("isSuccess", true);
		} else {
			result.put("isSuccess", false);
		}
		return result;
	}
}
