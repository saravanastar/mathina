/**
 * 
 */
package com.ask.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ask.exception.BusinessException;
import com.ask.pojo.UserPojo;
import com.ask.service.UserService;
import com.ask.util.ApplicationConstants;

/**
 * @author ASK
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	String test = "";

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public boolean registerUser(@Valid @RequestBody UserPojo user) throws BusinessException {

		boolean isUserAdded = userService.addUser(user);
		return isUserAdded;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	public ResponseEntity<?> loginGetUser(HttpServletRequest request, HttpServletResponse response) {
		Object object = request.getSession().getAttribute(ApplicationConstants.LOGGED_IN_USER);
		UserPojo user = null;
		if (object != null) {
			user = (UserPojo) object;
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	/**
	 * 
	 * @param user
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> loginUser(@RequestBody UserPojo user, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(user.getUserName());
		UserPojo userData = userService.getUser(user.getUserName(), user.getPassword());
		if (userData != null && userData.getUserName() != null) {
			SecurityContextHolder.getContext().setAuthentication(userService.getUserAuthentication(userData));
			request.getSession().setAttribute(ApplicationConstants.LOGGED_IN_USER, userData);
			request.getSession().setAttribute(ApplicationConstants.LOGGED_IN, true);
		}
		return ResponseEntity.ok().build();
	}

	/**
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/signout", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> logoutUser(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute(ApplicationConstants.LOGGED_IN_USER);
		request.getSession().removeAttribute(ApplicationConstants.LOGGED_IN);
		request.getSession().invalidate();
		return ResponseEntity.ok().build();
	}
}
