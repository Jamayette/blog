package com.jamayette.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
		if ("jamayette".equals(request.getSession().getAttribute("token"))) {
			return true;
		} else {
			response.sendRedirect("/auth");
		}
		return false;
	}

}
