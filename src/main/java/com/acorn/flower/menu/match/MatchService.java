package com.acorn.flower.menu.match;

import java.util.List;

import com.acorn.flower.menu.option.OptionListDto;

public interface MatchService {
	public void addMatch(MatchDto dto);
	public void deleteMatch(int id);
	public List<MatchListDto> getOptionAndMatchList(int option_id);
}
