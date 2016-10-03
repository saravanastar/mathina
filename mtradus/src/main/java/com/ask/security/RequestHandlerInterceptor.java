package com.ask.security;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ask.util.ApplicationConstants;

public class RequestHandlerInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		Object object = request.getSession().getAttribute(ApplicationConstants.LOGGED_IN);
		if (object != null) {
			serCookie(request, response, (boolean) object);
		} else {
			serCookie(request, response, false);
		}

	}

	public void serCookie(HttpServletRequest request, HttpServletResponse response, Object object) {
		Cookie cookie = new Cookie("loggedInStatus", String.valueOf((boolean) object));
		cookie.setPath(request.getContextPath());
		cookie.setSecure(true);
		cookie.setMaxAge(1000 * 60);
		response.addCookie(cookie);
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

}
