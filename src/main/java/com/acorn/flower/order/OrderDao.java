package com.acorn.flower.order;

import java.util.List;
import java.util.Set;

public interface OrderDao {
	public void insert(OrderDto dto);
	public List<ListDto> getOrders(int id);
	public boolean checkOrder(int id);
	public boolean deleteOrder(int id);
	public Set<Integer> getOrderId();
	public int getTotalPrice(int id);
}
