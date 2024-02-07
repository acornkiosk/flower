package com.acorn.flower.kiosk;

import java.util.List;

public interface KioskDao {
	
	public void insert(KioskDto dto);
	public KioskDto getKiosk(int id);
	public List<KioskDto> getKioskList();
	public void delete(int id);
	public void turnOn(int id);
	public void turnOff(int id);
	public void turnOnAll();
	public void turnOffAll();
	public void updateLocation(KioskDto dto);
}
