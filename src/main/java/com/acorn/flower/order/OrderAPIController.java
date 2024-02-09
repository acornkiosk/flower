package com.acorn.flower.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 주문 관리
 */
@RestController
public class OrderAPIController {
	
	@Autowired
	private OrderService service;
	
	/**
	 * 주문 추가
	 * @param dto
	 * @return
	 */
	@PostMapping("/api/order")
	public Map<String, Object> addOrder(@RequestBody OrderDto dto) {
		Map<String, Object> result = new HashMap<String, Object>();
		service.addOrder(dto);
		result.put("isSuccess", true);
		return result;
	}
	
	/**
	 * 주문번호 상세 리스트 획득
	 * @param id
	 * @return
	 */
	@GetMapping("/api/orders/{id}")
	public Map<String, Object> getOrders(@PathVariable int id) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<ListDto> list = service.getOrders(id);
		if(service.checkOrder(id)) {
			result.put("list", list);
			result.put("isSuccess", true);
		}else {
			result.put("list",null);
			result.put("isSuccess", false);
		}
		
		return result;
	}
	
	/**
	 * 주문 제작 다했을 시 주문 삭제 용도
	 * @param id
	 * @return
	 */
	@DeleteMapping("/api/orders/{id}")
	public Map<String, Object> deleteOrders(@PathVariable int id) {
		Map<String, Object> result = new HashMap<String, Object>();
		if(service.deleteOrder(id)) {
			result.put("isSuccess", true);
		}else {
			result.put("isSuccess", false);
		}
		
		return result;
	}
	
	/**
	 * 주문번호 리스트 획득
	 * @return
	 */
	@GetMapping("api/orders/id")
	public Map<String, Object> getOrders() {
		Map<String, Object> result = new HashMap<String, Object>();
		Set<Integer> set = service.getOrderId();
		if(!set.isEmpty()) {
			result.put("list", set);
			result.put("isSuccess", true);
		}else {
			result.put("list",null);
			result.put("isSuccess", false);
		}
		
		return result;
	}
	
}
