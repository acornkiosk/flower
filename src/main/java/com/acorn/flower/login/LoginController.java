package com.acorn.flower.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	//비로그인사용자  폼 요청
	@GetMapping("/login/required_loginform")
	public String requriedLoginForm() {
		return "login/required_loginform";
	}
	
	//로그인 폼 요청
	@GetMapping("/login/login_form")
	public String login_form() {
		return "login/login_form";
	}
	
	//로그인 실패시
	@PostMapping("/login/fail")
	public String loginFail() {
		return "login/fail";
	}
	
	//로그인성공
	@PostMapping("/login/pass")
	public String loginPass() {
		return "login/pass";
	}
	
	//ceo 관리
	@GetMapping("/owner/test/manage")
	public String manage() {
		return "test/manage";
	}
	
	
	@GetMapping("/super/test/kiosk")
	public String kiosk() {
		return "test/kiosk";
		
	}
	
	@GetMapping("/user/test/menu")
	public String menu() {
		return "test/menu";
	}
	@GetMapping("/login/roleFail")
	public String roleFail() {
		return "login/roleFail";
	}
}
