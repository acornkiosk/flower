package com.acorn.flower.kiosk;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KioskDaoImpl implements KioskDao {

	@Autowired
	private SqlSession session;
	@Override
	public void insert(KioskDto dto) {
		session.insert("kiosk.insert",dto);
	}
	@Override
	public KioskDto getKiosk(int id) {
		return session.selectOne("kiosk.getKiosk",id);
	}
	@Override
	public List<KioskDto> getKioskList() {
		return session.selectList("kiosk.getKioskList");
	}
	@Override
	public void delete(int id) {
		session.delete("kiosk.delete",id);
	}
	@Override
	public void turnOn(int id) {
		session.update("kiosk.turnOn",id);
	}
	@Override
	public void turnOff(int id) {
		session.update("kiosk.turnOff",id);
	}
	@Override
	public void turnOnAll() {
		session.update("kiosk.turnOnAll");
		
	}
	@Override
	public void turnOffAll() {
		session.update("kiosk.turnOffAll");
		
	}
	@Override
	public void updateLocation(KioskDto dto) {
		session.update("kiosk.updateLocation",dto);
		
	}

}
