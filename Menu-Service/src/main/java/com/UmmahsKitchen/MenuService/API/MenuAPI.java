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
@RequestMapping("/menu-service")	
public class MenuAPI {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	MenuService menuService;
	
	final static Logger logger = Logger.getLogger(MenuAPI.class);
	
	/**
	 * @return
	 * health check of services API
	 */
	@GetMapping("/")
	public String plainRequest() {
		logger.info("Reached API internally from root!!!");
		return restTemplate.getForObject("http://user-service/user-internal/", String.class);
	}
	
	@PostMapping(value = "/insert-all-menu-items")
	public String insertAllMenuItems(@RequestBody final List<MenuItemsVO> items) {
		menuService.insertAllMenuItems(items);
		return "Added Successfully";
	}
	
	@GetMapping(value = "/get-all-menu-items")
	public List<MenuItemsVO> getAllMenuItems() {
		return menuService.getAllItems();
	}
	
	/**
	 * @return
	 * This API was implemented to establish internal communication 
	 * from root service to menu service but now I am commenting this API
	 * and bring the API from root service to here and making root service as API gateway
	 */
//	@GetMapping("/get-all-items")
//	public List<MenuItemsVO> getAllMenuItems() {
//		return menuService.getAllItems();
//	}
	
	/**
	 * @param items
	 * This API was implemented to establish internal communication 
	 * from root service to menu service but now I am commenting this API
	 * and bring the API from root service to here and making root service as API gateway
	 * @return
	 */
//	@PostMapping(value = "/insert-all-items")
//	public String insertAllMenuItems(@RequestBody final List<MenuItemsVO> items) {
//		menuService.insertAllMenuItems(items);
//		return "Added sucessfully";
//	}
}
