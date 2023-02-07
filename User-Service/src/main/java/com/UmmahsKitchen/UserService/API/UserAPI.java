package com.UmmahsKitchen.UserService.API;

import java.util.List;

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
@RequestMapping("/user-internal")
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
	
	@PostMapping("/insert")
	public UsersVO insertuser(@RequestBody final UsersVO user) {
		return userService.addNewUser(user);
	}
	
	@GetMapping(value = "/get")
	public UsersVO getUser(@RequestParam(name="id") final String userId) {
		return userService.getUser(userId);
	}
}