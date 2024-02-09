package com.acorn.flower.order;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {
	@Autowired
	private SqlSession session;

	@Override
	public void insert(OrderDto dto) {
		session.insert("order.insert", dto);
	}

	@Override
	public List<ListDto> getOrders(int id) {
		return session.selectList("order.getOrders", id);
	}

	@Override
	public boolean checkOrder(int id) {
		int count = session.selectOne("order.checkOrder", id);
		if (count > 0)
			return true;
		return false;
	}

	@Override
	public boolean deleteOrder(int id) {
		session.delete("order.deleteOrder",id);
		int count = session.selectOne("order.checkOrder", id);
		if (count == 0)
			return true;
		return false;
	}

	@Override
	public Set<Integer> getOrderId() {
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> list = session.selectList("order.getOrderId");
		for(int i : list) {
			set.add(i);
		}
		return set;
	}

}
