package com.UmmahsKitchen.UserService.API;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.UmmahsKitchen.UserService.Service.UserService;
import com.UmmahsKitchen.UserService.VO.UsersVO;

@RestController
@RequestMapping("/user-service")
public class UserAPI {
	
	@Autowired
	UserService userService;
	
	private final String EMPLOYEE_ENDPOINTS_RUNNING = "Result from User after travelling through Menu";
	final static Logger logger = Logger.getLogger(UserAPI.class);
	
	@GetMapping("/")
	public String plainRequest() {
		logger.info("USER Reached API internally!!!");
		return EMPLOYEE_ENDPOINTS_RUNNING;
	}
	
	@PostMapping(value = "/insert-user")
	public UsersVO insertUser(@RequestBody final UsersVO user) {
		return userService.addNewUser(user);
	}
	
	@GetMapping(value = "/get-user")
	public UsersVO getUser(@RequestParam(name="id") final String userId) {
		return userService.getUser(userId);
	}
	
	/**
	 * @param userId
	 * @return commenting this API and bring API from root-service since
	 * I am converting it into API-gateway
	 */
//	@GetMapping(value = "/get")
//	public UsersVO getUser(@RequestParam(name="id") final String userId) {
//		return userService.getUser(userId);
//	}
}