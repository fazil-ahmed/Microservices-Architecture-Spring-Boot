package com.UmmahsKitchen.RootService.API;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.UmmahsKitchen.RootService.CommonVO.MenuItemsVO;
import com.UmmahsKitchen.RootService.CommonVO.UsersVO;


@RestController
@RequestMapping("/root")	
public class RootAPI {
	
	final static Logger logger = Logger.getLogger(RootAPI.class);

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/")
	public String plainRequest() {
		logger.info("Reached API!!!");
		String result = restTemplate.getForObject("http://menu-service/menu-internal/",String.class);
		
		return result;  
	}
	
	@PostMapping(value = "/insert-all-menu-items")
	public String insertAllMenuItems(@RequestBody final List<MenuItemsVO> items) {
		return restTemplate.postForObject("http://menu-service/menu-internal/insert-all-items", items, String.class);
	}
	
	
	@GetMapping(value = "/get-all-menu-items")
	public List<MenuItemsVO> getAllMenuItems() {
		return restTemplate.getForObject("http://menu-service/menu-internal/get-all-items", List.class);
	}
	
	@PostMapping(value = "/insert-user")
	public UsersVO insertUser(@RequestBody final UsersVO user) {
		return restTemplate.postForObject("http://user-service/user-internal/insert", user, UsersVO.class);
	}
	
	@GetMapping(value = "/get-user")
	public UsersVO getUser(@RequestParam(name="id") final String userId) {
		return restTemplate.getForObject("http://user-service/user-internal/get?id="+userId, UsersVO.class);
	}
}
