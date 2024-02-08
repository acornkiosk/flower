package com.acorn.flower.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	// 직원관리 페이지 이동
	@GetMapping("/owner/user/index")
	public String userIndex() {
		return "user/index";
	}

	// 로그인 폼 요청
	@GetMapping("/user/login_form")
	public String login_form() {
		return "user/login_form";
	}

	// 로그인 실패시
	@PostMapping("/user/fail")
	public String loginFail() {
		return "user/fail";
	}

	// 로그인성공
	@PostMapping("/user/pass")
	public String loginPass() {
		return "user/pass";
	}

	@GetMapping("/user/test/menu")
	public String menu() {
		return "test/menu";
	}

	// 권한에 맞지않은 사용자가 들어올때
	@GetMapping("/user/roleFail")
	public String roleFail() {
		return "user/roleFail";
	}
}
