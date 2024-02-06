package com.acorn.flower.menu;

import org.springframework.ui.Model;

public interface MenuService {
	public void addMenu(MenuDto dto);
	public void updateMenu(MenuDto dto);
	public void deleteMenu(int id);
	public void getList(Model model);
	public void getData(Model model, int id);
}
