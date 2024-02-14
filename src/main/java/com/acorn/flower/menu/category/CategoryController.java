package com.acorn.flower.menu.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acorn.flower.menu.MenuDto;
import com.acorn.flower.menu.MenuDto;
import com.acorn.flower.menu.MenuService;

/**
 * 카테고리 정보를 다루는 컨트롤러 
 * <br>
 * 한줄 주석으로 '/====' 문장이 있는 구간이 기준입니다. 
 * <br>
 * 위에는 기존 코드입니다. menu/category/insert_form.html 
 * <br>
 * 아래는 수정코드입니다. menu/category/insert_form2.html 실험중입니다.
 * <br>
 * @author "이승우", "김대원"
 * @since 2024-02-10
 * @version 0.1 / 프로젝트 버전
 */

@Controller
public class CategoryController {
	@Autowired private CategoryService service;
	@Autowired private MenuService menuService;
	
	/** 1.카테고리 등록 페이지 이동처리 */
	@GetMapping("/menu/category/insert_form")
	public String insertForm2(Model model) {
		List<CategoryDto> list = service.getList();
		model.addAttribute("list", list);
		return "menu/category/insert_form";
	}
	
	/** 2.등록 페이지 내에서 javascript fetch 함수로 부름 : 사용안함 */
	
	/** 3.폼으로 데이터 저장 */
	@PostMapping("/menu/category/insert")
	public String insert(CategoryDto dto) {
		service.addCategory(dto);
		return "menu/category/insert_form";
	}
	
	/** 4.데이터 삭제 : 이제 사용함  */
	@ResponseBody
	@GetMapping("/menu/category/delete/{id}")
	public List<MenuDto> DeleteCategory(@PathVariable int id) {
		CategoryDto dto = service.getData(id);
		service.deleteCategory(id);
		// 삭제한 값을 최신화 해주기 위해서 list를 리턴함
		List<MenuDto> list = menuService.getList(dto);
		return list;
	}
	
	/** 5.카테고리에 속한 메뉴DB getList : 추가한 메서드  */
	@ResponseBody
	@GetMapping("/menu/category/menuDB/{id}")
	public List<MenuDto> menuDB(@PathVariable int id){
		CategoryDto beforeDto = service.getData(id);
		List<MenuDto> list = menuService.getList(beforeDto);
		return list;
	}
	
	
	/** 6.카테고리로 메뉴DB 수정 : 추가한 메서드 */
	@ResponseBody
	@PostMapping("/menu/category/updateMenu")
	public String updateMenu(MenuDto dto) {
		service.updateMenu(dto);
		return "connectMenuDB";
	}
	
	/** 7.카테고리 수정 : 추가한 메서드 */
	@ResponseBody
	@PostMapping("/menu/category/update")
	public String update(CategoryDto dto) {
		service.updateCategory(dto);
		return "updateComplet";
	}

	/** 카테고리가 일치하는 메뉴의 갯수*/
	@ResponseBody
	@GetMapping("/menu/category/menuRowCount/{id}")
	public int menuCategoryRowCount(@PathVariable int id){
		return service.menuCategoryCount(id);
		
	}
	
	

	
}
