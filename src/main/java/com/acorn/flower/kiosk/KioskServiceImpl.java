package com.acorn.flower.kiosk;

import java.util.List;

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

	@Override
	public KioskDto getKiosk(int id) {
		return dao.getKiosk(id);
	}

	@Override
	public List<KioskDto> getKioskList() {
		return dao.getKioskList();
	}

	@Override
	public void deleteKiosk(int id) {
		dao.delete(id);
	}

	@Override
	public void turnOn(int id) {
		dao.turnOn(id);
	}

	@Override
	public void turnOff(int id) {
		dao.turnOff(id);

	}

	@Override
	public void turnOnAll() {
		dao.turnOnAll();

	}

	@Override
	public void turnOffAll() {
		dao.turnOffAll();

	}

}
