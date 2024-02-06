package com.acorn.flower.kiosk;

import java.util.List;

public interface KioskService {
	public void addKiosk(KioskDto dto);

	public KioskDto getKiosk(int id);

	public List<KioskDto> getKioskList();

	public void deleteKiosk(int id);

	public void turnOn(int id);

	public void turnOff(int id);

	public void turnOnAll();

	public void turnOffAll();
}
