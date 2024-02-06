package com.acorn.flower.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestUserController {

	@GetMapping("/test/user/login_form")
	public String userLoginForm() {
		return "test/user/login_form";
	}
}
