package com.acorn.flower.kiosk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KioskServiceImpl implements KioskService {

	@Autowired
	private KioskDao dao;
	@Override
	public void addKiosk(KioskDto dto) {
		dao.insert(dto);
	}

}
