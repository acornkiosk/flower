package com.acorn.flower.menu.option_details;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * React 리팩토링 대비코드, API 활용 optionDetails관리 Controller <br>
 * 
 * @author "이승우", "김대원"
 * @since 2024-02-07
 * @version 0.1 / 프로젝트 버전
 */
@RestController
public class OptionDetailsAPIController {
	@Autowired 
	private OptionDetailsService optionDetailsService;
	
	
	
	
	/** Select : get_optionDetailsList(옵션 세부항목 조회) */
	@GetMapping("api/optionDetails/list")
	public Map<String, Object> optionDetailsList() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<OptionDetailsDto> list=optionDetailsService.getList();
		
		if(list != null) {
			result.put("isSuccess", true);
			result.put("list", list);
		} else { 
			result.put("isSuccess", false);
			result.put("list", null);
		}
		return result;
	}
	
	/** Select : get_optionDetails(특정 메뉴 가져오기)*/
	@GetMapping("api/optionsDetails/{id}")
	public Map<String, Object> optionsDetails(@PathVariable int id){
		Map<String, Object> result = new HashMap<String, Object>();
		OptionDetailsDto dto=optionDetailsService.getData(id);
		if(dto != null) {
			result.put("isSuccess", true);
			result.put("dto", dto);
		} else { 
			result.put("isSuccess", false);
			result.put("dto", null);
		}
		return result;
	}
	
	
	/** Insert : insert_optionDetails(옵션 세부항목 등록)*/
	@PostMapping("api/optionDetails")
	public void insertOptionDetails(OptionDetailsDto dto) {
		optionDetailsService.addOptionDetails(dto);
	}
	
	/** Update : update_optionDetails(메뉴수정) */
	
	
	/** Delete : delete_optionDetails(메뉴삭제) */
	
	
}
