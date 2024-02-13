package com.acorn.flower.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService service;
	@GetMapping("/order/list")
	public String orderList(Model model) {
		List<Integer> orderIds = new ArrayList<Integer>(service.getOrderId());
		Map<Integer,List<ListDto>> map = new HashMap<Integer, List<ListDto>>();
		for(int id : orderIds) {
			map.put(id, service.getOrders(id));
		}
		
		model.addAttribute("map",map);
		
		return "order/list";
	}
}
