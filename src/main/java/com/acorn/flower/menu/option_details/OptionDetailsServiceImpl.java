package com.acorn.flower.menu.option_details;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionDetailsServiceImpl implements OptionDetailsService{
	@Autowired private OptionDetailsDao optionDetailsDao; 
	
	@Override
	public void addOptionDetails(OptionDetailsDto dto) {
		optionDetailsDao.insert(dto);	
	}

	@Override
	public List<OptionDetailsDto> getList() {
		return optionDetailsDao.getList();
	}

	@Override
	public OptionDetailsDto getData(int id) {
		
		return optionDetailsDao.getData(id);
	}

	@Override
	public void updateOptionDetails(OptionDetailsDto dto) {
		// TODO Auto-generated method stub
		
	}

}
