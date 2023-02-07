package com.UmmahsKitchen.MenuService.API;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.UmmahsKitchen.MenuService.Services.MenuService;
import com.UmmahsKitchen.MenuService.VO.MenuItemsVO;



@RestController
@RequestMapping("/menu-internal")	
public class MenuAPI {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	MenuService menuService;
	
	final static Logger logger = Logger.getLogger(MenuAPI.class);
	
	@GetMapping("/")
	public String plainRequest() {
		logger.info("Reached API internally from root!!!");
		return restTemplate.getForObject("http://user-service/user-internal/", String.class);
	}
	
	@GetMapping("/get-all-items")
	public List<MenuItemsVO> getAllMenuItems() {
		return menuService.getAllItems();
	}
	
	@PostMapping(value = "/insert-all-items")
	public String insertAllMenuItems(@RequestBody final List<MenuItemsVO> items) {
		menuService.insertAllMenuItems(items);
		return "Added sucessfully";
	}
}
