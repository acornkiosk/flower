package com.acorn.flower.config;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	
	
	// 1.요청캐쉬 객체를 직접 생성해서
	private RequestCache requestCache = new HttpSessionRequestCache();

	// 2.생성자에서 부모객체에 전달
	public AuthSuccessHandler() {
		super.setRequestCache(requestCache);
	}
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,HttpServletResponse response,
			 Authentication authentication) throws ServletException,IOException{
		
		HttpSession session=request.getSession();
		session.setMaxInactiveInterval(60*60*10);
		
		//AUthentication 객체의 메소드를 이요해서 지금 로그인된 사용자에 대한 자세한 정보를 얻어낼수 있다.
		String id=authentication.getName();

		//sessin 에 저장하기
		session.setAttribute("id", id);
		
		

		
		//체크박스 체크할 경우 쿠키값을 생성한다.	
		if("save-id".equals(request.getParameter("save-id"))) {
			//쿠키 생성하기
			Cookie cookie=new Cookie("cid",id);
			cookie.setMaxAge(60*60);
			cookie.setPath(request.getContextPath());
			response.addCookie(cookie);

			System.out.println("yes:"+request.getParameter("save-id"));
			
		}
		//체크박스 체크 하지 않을 경우 쿠키값을 삭제해준다.
		else {
			//쿠키 삭제하기
			Cookie cookie=new Cookie("cid","");
			cookie.setMaxAge(0);
			cookie.setPath(request.getContextPath());
			response.addCookie(cookie);
			
			System.out.println("no:"+request.getParameter("save-id"));
		}

		
		
		// 3. 로그인 성공이후 미리 저장된 요청이 있었는지 읽어와서
		SavedRequest cashed=requestCache.getRequest(request, response);
		
		// 4.만일 미리 저장된 요청이 없다면 (로그인 하지 않은 상태로 인증이 필요한 경로를 요청하지 않았다면)
		if(cashed==null) {
			// 5. 로그인 환영 페이지로 foward 이동 시켜준다
			RequestDispatcher rd=request.getRequestDispatcher("/user/pass");
			rd.forward(request, response);
		}else {
			// 6. 원래 가려던 목적지 경로가 있으면 리다이렉트 이동 시킨다.
			super.onAuthenticationSuccess(request, response, authentication);
		}
		
	}
	
}