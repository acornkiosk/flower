package com.acorn.flower.menu.option_details;

import java.util.List;

public interface OptionDetailsDao {
	public void insert(OptionDetailsDto dto);
	public List<OptionDetailsDto> getList();
	public OptionDetailsDto getData(int id);
	public void update(OptionDetailsDto dto);
	public void delete(int id);
	
}
