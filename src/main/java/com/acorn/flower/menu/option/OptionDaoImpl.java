package com.acorn.flower.menu.option;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OptionDaoImpl implements OptionDao {
	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(OptionDto dto) {
		session.insert("option.insert",dto);
	}

	@Override
	public List<OptionDto> getList() {
		
		return session.selectList("option.getList");
	}

	@Override
	public OptionDto getData(int id) {
		return session.selectOne("option.getData",id);
	}

	@Override
	public void update(OptionDto dto) {
		session.update("option.update",dto);
		
	}

	@Override
	public void delete(int id) {
		session.delete("option.delete",id);
		
	}

	@Override
	public List<OptionListDto> getOptionAndDetailsList(int option_id) {
		return session.selectList("option.getOptionAndDetailsList",option_id);
		 
	}


}
