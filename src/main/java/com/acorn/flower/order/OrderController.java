package com.acorn.flower.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.socket.TextMessage;

import com.acorn.flower.config.WebSocketKeeper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class OrderController {

	@Autowired
	private OrderService service;

	@Autowired
	private WebSocketKeeper keeper;

	@GetMapping("/order/list")
	public String orderList(Model model) throws IOException {
		List<Integer> orderIds = new ArrayList<Integer>(service.getOrderId());
		Map<Integer, List<ListDto>> map = new HashMap<Integer, List<ListDto>>();
		for (int id : orderIds) {
			map.put(id, service.getOrders(id));
		}
		model.addAttribute("map", map);

		return "order/list";
	}

	@GetMapping("/order/refresh")
	public String refresh() throws IOException {
		// 객체에 저장된 내용ㅇ르 json문자열로 변환
		List<Integer> orderIds = new ArrayList<Integer>(service.getOrderId());
		Map<Integer, List<ListDto>> map = new HashMap<Integer, List<ListDto>>();
		for (int id : orderIds) {
			map.put(id, service.getOrders(id));
		}
		ObjectMapper mapper = new ObjectMapper();
		String msg = mapper.writeValueAsString(map);
		TextMessage message = new TextMessage(msg);
		
		return "order/list";
	}
}
