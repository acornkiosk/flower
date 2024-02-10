package com.acorn.flower.menu.category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * React 리팩토링 대비코드, API 활용 카테고리관리 Controller <br>
 * 
 * @author "이승우", "김대원"
 * @since 2024-02-07
 * @version 0.1 / 프로젝트 버전
 */

@RestController
public class CategoryApiController {
	
	@Autowired
	private CategoryService categoryService;

	/** Select : get_categoryList(카테고리 조회) */
	@GetMapping("/api/category/list")
	public Map<String, Object> getCategoryList() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<CategoryDto> list = categoryService.getList();
		
		if(list != null) {
			result.put("isSuccess", true);
			result.put("list", list);
		} else { 
			result.put("isSuccess", false);
			result.put("list", list);
		}
		return result;
	}
	/** Insert : insert_category(카테고리 등록)*/
	@PostMapping("/api/category")
	public void insertCategory(CategoryDto dto) {
		categoryService.addCategory(dto);
	}
	/** Delete : delete_category(카테고리 삭제)*/
	@DeleteMapping("/api/category/{id}")
	public void deleteCategory(@PathVariable int id) {
		categoryService.deleteCategory(id);
	}
}
