package com.acorn.flower.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.acorn.flower.menu.MenuDto;
import com.acorn.flower.menu.MenuService;
import com.acorn.flower.order.ListDto;
import com.acorn.flower.order.OrderDto;
import com.acorn.flower.order.OrderService;

@Controller
public class MainController {
	private int order_id = 0;
	@Autowired
	private MenuService menuService;

	@Autowired
	private OrderService orderSerivce;
	@GetMapping("/main")
	public String main(Model model) {
		List<MenuDto> list = menuService.getList();
		List<ListDto> cart = orderSerivce.getOrders(order_id);
		int totalPrice = orderSerivce.getTotalPrice(order_id);
		model.addAttribute("list",list);
		model.addAttribute("cart",cart);
		model.addAttribute("totalPrice",totalPrice);
		return "main/index";
	}
	
	@GetMapping("/main/detail")
	public String mainDetail(Model model,int id) {
		MenuDto menu = menuService.getData(id);
		model.addAttribute("menu",menu);
		return "main/detail";
	}
	
	@PostMapping("/main/addCart")
	public String mainAddCart(OrderDto dto) {
		dto.setId(order_id);
		orderSerivce.addOrder(dto);
		return "redirect:/main";
	}
}
