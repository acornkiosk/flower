package com.acorn.flower.menu.option;

import org.springframework.beans.factory.annotation.Autowired;
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
	private OptionService service;
	
	
	/** Insert : insert_option(옵션 등록)*/
	@PostMapping("/api/option")
	public void insertOption(OptionDto dto) {
		service.addOption(dto);
	}
}
