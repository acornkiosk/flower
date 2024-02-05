package com.acorn.flower.menu;

import java.io.File;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired private MenuDao menuDao;

	
	@Override
	public void addMenu(MenuDto dto) {
		
		menuDao.insert(dto);
		
	}

	@Override
	public void updateMenu(MenuDto dto) {
		menuDao.update(dto);
		
	}

	@Override
	public void deleteMenu(int id) {
		menuDao.delete(id);
		
	}
	
	
}
