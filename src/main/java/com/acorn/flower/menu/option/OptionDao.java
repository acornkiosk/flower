package com.acorn.flower.menu.option;

import java.util.List;



public interface OptionDao {
	public void insert(OptionDto dto);
	public List<OptionDto> getList();
	public OptionDto getData(int id);
	public void update(OptionDto dto);
	public void delete(int id);
	public List<OptionListDto> getOptionAndDetailsList(int option_id);
}
