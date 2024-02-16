package com.acorn.flower.menu.option_details;

import java.util.List;

public interface OptionDetailsService {
	public void addOptionDetails(OptionDetailsDto dto);
	public List<OptionDetailsDto> getList();
	public OptionDetailsDto getData(int id);
	public void updateOptionDetails(OptionDetailsDto dto);
	public void deleteOptionDetails(int id);
	
}
