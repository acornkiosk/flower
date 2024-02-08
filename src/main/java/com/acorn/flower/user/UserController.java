package com.acorn.flower.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/owner/user/index")
	public String userIndex() {
		return "user/index";
	}
}
