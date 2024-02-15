package com.acorn.flower.menu.option;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * React 리팩토링 대비코드, API 활용 option관리 Controller <br>
 * 
 * @author "이승우", "김대원"
 * @since 2024-02-07
 * @version 0.1 / 프로젝트 버전
 */


@RestController
public class OptionApiController {
	@Autowired
	private OptionService optionService;
	
	/** Select : get_optionList(옵션조회) */
	@GetMapping("api/option/list")
	public Map<String, Object> optionList() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<OptionDto> list=optionService.getList();
		
		if(list != null) {
			result.put("isSuccess", true);
			result.put("list", list);
		} else { 
			result.put("isSuccess", false);
			result.put("list", null);
		}
		return result;
	}
	
	/** Select : get_option(특정 메뉴 가져오기)*/
	@GetMapping("api/options/{id}")
	public Map<String, Object> options(@PathVariable int id){
		Map<String, Object> result = new HashMap<String, Object>();
		OptionDto dto=optionService.getData(id);
		if(dto != null) {
			result.put("isSuccess", true);
			result.put("dto", dto);
		} else { 
			result.put("isSuccess", false);
			result.put("dto", null);
		}
		return result;
	}
	
	/** Insert : insert_option(옵션 등록)*/
	@PostMapping("/api/option")
	public void insertOption(OptionDto dto) {
		optionService.addOption(dto);
	}
	
	/** Update : update_option(옵션 수정) */
	@PatchMapping("api/option")
	public void updateOptionDetails(OptionDto dto) {
		optionService.updateOption(dto);
	}
	
	/** Delete : delete_option(옵션 삭제) */
	@DeleteMapping("api/option/{id}")
	public void deleteOptionDetails(@PathVariable int id) {
		optionService.deleteOption(id);
	}
}
