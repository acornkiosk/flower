package com.acorn.flower.menu.option;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OptionServiceImpl implements OptionService {
	@Autowired private OptionDao optionDao;

	
	@Override
	public void addOption(OptionDto dto) {
		optionDao.insert(dto);
	}
	
	@Override
	public List<OptionDto> getList() {
		return optionDao.getList();
	}


	@Override
	public OptionDto getData(int id) {
		return optionDao.getData(id);
	}


	@Override
	public void updateOption(OptionDto dto) {
		optionDao.update(dto);
		
	}


	@Override
	public void deleteOption(int id) {
		optionDao.delete(id);
		
	}

}
