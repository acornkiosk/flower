package com.acorn.flower.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {

	
	// 로그인 폼 요청
	@GetMapping("/user/login_form")
	public String loginForm(@CookieValue(value = "cid", required = false) String cid, Model model) {
	  // required=false 는 애노테이션을 통해 cookie 값을 가져오는데 쿠키값이 없으면 페이지가 안열리기때문에 쿠기가 존재 하지않을때도 페이지 처리를 하기 위해 사용한다.
	        model.addAttribute("cid", cid);
	   
	    return "user/login_form";
	}

	//로그인 실패시
	@PostMapping("/user/fail")
	@ResponseBody
	public String loginFail() {
	
		return "<script> alert('로그인 실패 했습니다.다시 로그인 해주세요!'); window.location.href = '/flower/user/login_form'</script>";
	}
	
	//로그인성공
	@PostMapping("/user/pass")
	@ResponseBody
	public String loginPass() {
		return "<script> alert('로그인 성공 했습니다.'); window.location.href = '/flower'</script>";
	}
	
	//ceo 관리
	@GetMapping("/owner/test/manage")
	public String manage() {
		
		return "test/manage";
	}
	
	
	@GetMapping("/user/test/menu")
	public String menu() {
		return "test/menu";
	}
	//권한에 맞지않은 사용자가 들어올때
	@GetMapping("/user/roleFail")
	public String roleFail() {
		return "user/roleFail";
	}
	

	/**
	 * 로그아웃 하면 로그인 페이지로 리디렉션
	 * @return
	 */
	@GetMapping("/logout")
	public String logoutPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            SecurityContextHolder.getContext().setAuthentication(null); // 현재 사용자 인증 해제
        }
        return "redirect:/user/login_form"; // 로그인 페이지로 리디렉션
    }

}
