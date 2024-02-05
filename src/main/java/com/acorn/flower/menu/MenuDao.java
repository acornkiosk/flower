package com.acorn.flower.menu;

public interface MenuDao {
	public void insert(MenuDto dto);
	public void update(MenuDto dto);
	public void delete(int id);
}
