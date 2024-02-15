package com.acorn.flower.menu.option_details;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OptionDetailsDaoImpl implements OptionDetailsDao{
	@Autowired private SqlSession session;

	@Override
	public void insert(OptionDetailsDto dto) {
		session.insert("optionDetails.insert",dto);
	}

	@Override
	public List<OptionDetailsDto> getList() {
		
		return session.selectList("optionDetails.getList");
	}

	@Override
	public OptionDetailsDto getData(int id) {
		
		return session.selectOne("optionDetails.getData",id);
	}

	@Override
	public void update(OptionDetailsDto dto) {
		session.update("optionDetails.update",dto);
		
	}

	@Override
	public void delete(int id) {
		session.delete("optionDetails.delete",id);
		
	}
	
	
}
