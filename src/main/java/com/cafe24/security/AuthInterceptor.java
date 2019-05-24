package com.cafe24.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cafe24.mysite.vo.UserVo;

public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 1. handler 종류 확인
		if (handler instanceof HandlerMethod == false) {
			return true;
		}

		// 2.casting
		HandlerMethod handlerMethod = (HandlerMethod) handler;

		// 3. Method의 @Auth 받아오기
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);

		// 4. Method에 @Auth 없으면? class(type)에 @auth를 받아오기
//		if(auth == null) {
//			auth = ...
//		}

		// 5. @Auth가 안 붙어있는 경우
		if (auth == null) {
			return true;
		}

		// 6.@Auth가 (class또는 method에 붙어있기 때문에
		// 인증 여부 체크

		HttpSession session = request.getSession();

		if (session == null) { // 인증이 안되어있음
			response.sendRedirect(request.getContextPath());
			return false;
		}

		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if (authUser == null) { // 인증이 안되어있음
			response.sendRedirect(request.getContextPath());
			return false;
		}

		// 7. Role 가져오귀
		Auth.Role role = auth.role();

		// 8. role이 Auth.Role.User 라면,
		// 인증된 모든 사용자는 접근 가능
//		if(role==Auth.Role.USER) {
//			return true;
//		}
//
		
		// 9. Admin Role 권한 체큐
		//
		// authUser.getRole().equals("ADMIN")
		//
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
