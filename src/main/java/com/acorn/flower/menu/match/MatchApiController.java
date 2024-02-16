package com.acorn.flower.menu.match;



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
 * React 리팩토링 대비코드, API 활용 option관리 Controller <br>
 * 
 * @author "김대원"
 * @since 2024-02-16
 * @version 0.1 / 프로젝트 버전
 * 
 * 카테고리와 옵션을 연결해주는 기능
 */

@RestController
public class MatchApiController {
	@Autowired MatchService matchService;
	
	/** Insert : insert_option(매칭 등록)*/
	@PostMapping("/api/match")
	public void insertMatch(MatchDto dto) {
		matchService.addMatch(dto);
	}
	
	@DeleteMapping("api/match/{id}")
	public void deleteMatch(@PathVariable int id) {
		matchService.deleteMatch(id);	
	}
	
	/** Select : get_OptionsAndMatchList(특정 옵션과 매치된 카테고리 조회) */
	@GetMapping("api/option/Match/list/{option_id}")
	public Map<String, Object> getOptionsAndMatchList(@PathVariable int option_id){
		Map<String, Object> result = new HashMap<String, Object>();
		List<MatchListDto> list =matchService.getOptionAndMatchList(option_id);
		if(list != null) {
			result.put("isSuccess", true);
			result.put("list", list);
		} else { 
			result.put("isSuccess", false);
			result.put("list", null);
		}
		return result;
	}

}
