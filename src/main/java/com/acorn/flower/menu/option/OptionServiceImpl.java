package com.acorn.flower.menu.option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn.flower.menu.category.CategoryDao;
@Service
public class OptionServiceImpl implements OptionService {
	@Autowired private OptionDao optionDao;

	
	@Override
	public void addOption(OptionDto dto) {
		optionDao.insert(dto);
	}

}
