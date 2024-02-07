package com.acorn.flower.menu;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

public interface MenuService {
	public void addMenu(MenuDto dto);
	public void updateMenu(MenuDto dto);
	public void deleteMenu(int id);
	public void getList(Model model);
	// public Map<String, Object> getData(int id); // ApiController.java 용 
	public void getData(Model model, int id); // MenuController.java 용 
}
