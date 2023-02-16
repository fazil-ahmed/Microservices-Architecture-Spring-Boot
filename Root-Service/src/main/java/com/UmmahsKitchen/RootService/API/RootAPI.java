package com.UmmahsKitchen.RootService.API;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/root")	
public class RootAPI {
	
	final static Logger logger = Logger.getLogger(RootAPI.class);

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/")
	public String plainRequest() {
		logger.info("Reached API!!!");
//		String result = restTemplate.getForObject("http://menu-service/menu-internal/",String.class);
		
		return "Reached root and it has been registered changed";  
	}
	
	/**
	 * @param items
	 * @return commenting this API and moving it to Menu service API layer
	 */
//	@PostMapping(value = "/insert-all-menu-items")
//	public String insertAllMenuItems(@RequestBody final List<MenuItemsVO> items) {
//		return restTemplate.postForObject("http://menu-service/menu-internal/insert-all-items", items, String.class);
//	}
//	
	/**
	 * @param items
	 * @return commenting this API and moving it to Menu service API layer
	 */
//	@GetMapping(value = "/get-all-menu-items")
//	public List<MenuItemsVO> getAllMenuItems() {
//		return restTemplate.getForObject("http://menu-service/menu-internal/get-all-items", List.class);
//	}
	
	/**
	 * @param user
	 * @return commenting this API and moving it to API layer in User-Service
	 */
//	@PostMapping(value = "/insert-user")
//	public UsersVO insertUser(@RequestBody final UsersVO user) {
//		return restTemplate.postForObject("http://user-service/user-internal/insert", user, UsersVO.class);
//	}
	
	/**
	 * @param user
	 * @return commenting this API and moving it to API layer in User-Service
	 */
//	@GetMapping(value = "/get-user")
//	public UsersVO getUser(@RequestParam(name="id") final String userId) {
//		return restTemplate.getForObject("http://user-service/user-internal/get?id="+userId, UsersVO.class);
//	}
}
