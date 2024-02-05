package com.acorn.flower.kiosk;

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

}
