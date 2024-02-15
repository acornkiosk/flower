package com.acorn.flower.menu.option;

import java.util.List;



public interface OptionService {
	public void addOption(OptionDto dto);
	public List<OptionDto> getList();
	public OptionDto getData(int id);
	public void updateOption(OptionDto dto);
	public void deleteOption(int id);
}
