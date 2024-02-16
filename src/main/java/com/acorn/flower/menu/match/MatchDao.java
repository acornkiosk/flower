package com.acorn.flower.menu.match;

import java.util.List;

public interface MatchDao {
	public void insert(MatchDto dto);
	public void delete(int id);
	public List<MatchListDto> getOptionAndMatchList(int option_id);
}
