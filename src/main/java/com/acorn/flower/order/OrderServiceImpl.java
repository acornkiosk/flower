package com.acorn.flower.order;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao dao;
	@Override
	public void addOrder(OrderDto dto) {
		dao.insert(dto);
	}
	@Override
	public List<ListDto> getOrders(int id) {
		return dao.getOrders(id);
	}
	@Override
	public boolean checkOrder(int id) {
		return dao.checkOrder(id);
	}
	@Override
	public boolean deleteOrder(int id) {
		return dao.deleteOrder(id);
	}
	@Override
	public Set<Integer> getOrderId() {
		return dao.getOrderId();
	}
	@Override
	public int getTotalPrice(int id) {
		return dao.getTotalPrice(id);
	}
	
	
}
