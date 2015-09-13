/**
 * 
 */
package com.ask.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ask.dbpojo.User;
import com.ask.pojo.UserPojo;
import com.ask.service.UserService;
import com.ask.util.ApplicationConstants;

/**
 * @author sarav
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	private static int DEFAULT_LOAD = 1;

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

	@RequestMapping(value = "/default", method = RequestMethod.GET)
	public void welcomeUser(HttpSession session) {
		if (DEFAULT_LOAD == 1)
			System.out.println(userService.addDefaultData());
		DEFAULT_LOAD++;
		
//		if (session.getAttribute(ApplicationConstants.LOGGED_IN) == null) {
//			return "login";
//		}
		
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public boolean registerUser(@RequestBody User user) {
		
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
	public UserPojo loginGetUser(
			HttpServletRequest request, HttpServletResponse response) {
		
		UserPojo user = (UserPojo) request.getSession().getAttribute(ApplicationConstants.LOGGED_IN_USER);
		return user;

	}

	/**
	 * 
	 * @param user
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public void loginUser(@RequestBody UserPojo user,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println(user.getUserName());
		User userHib = userService.getUser(user);
		if (userHib != null && userHib.getUserName() != null) {
			request.getSession().setAttribute(ApplicationConstants.LOGGED_IN_USER, userHib);
			request.getSession().setAttribute(ApplicationConstants.LOGGED_IN, true);
		}
	}

	/**
	 * 
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/logout.htm", method = RequestMethod.PUT)
	public ResponseEntity<?> logoutUser(@RequestBody UserPojo user,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println(user.getUserName());
		request.getSession().removeAttribute(ApplicationConstants.LOGGED_IN_USER);
		request.getSession().removeAttribute(ApplicationConstants.LOGGED_IN);
		request.getSession().invalidate();
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
