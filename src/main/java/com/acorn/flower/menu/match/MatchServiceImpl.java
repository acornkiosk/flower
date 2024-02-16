package com.acorn.flower.menu.match;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService{
	@Autowired private MatchDao matchDao;

	@Override
	public void addMatch(MatchDto dto) {
		matchDao.insert(dto);
	}

	@Override
	public void deleteMatch(int id) {
		matchDao.delete(id);
		
	}

	@Override
	public List<MatchListDto> getOptionAndMatchList(int option_id) {
		List<MatchListDto> list= matchDao.getOptionAndMatchList(option_id);
		return list;
	}
	
	
}
