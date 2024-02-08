package com.acorn.flower.test;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TestController {
	
	@GetMapping("/")
	public String home(Model model) {
		
		return "test/index";
	}
	
	@GetMapping("/test/kiosk/index")
	public String kioskIndex() {
		return "test/kiosk/index";
	}
	
	@GetMapping("/test/login_form")
	public String testLoginForm() {
		return "/login_form";
	}
}
