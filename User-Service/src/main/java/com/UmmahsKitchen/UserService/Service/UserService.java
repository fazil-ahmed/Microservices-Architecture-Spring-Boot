package com.UmmahsKitchen.UserService.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.UmmahsKitchen.UserService.DAO.AbstractUserDAO;
import com.UmmahsKitchen.UserService.VO.UsersVO;

@Component
public class UserService {

	@Autowired
	AbstractUserDAO abstractUserDAO;
	
	public UsersVO addNewUser(UsersVO user) {
		user.setCreateTs(new Date().toString());
		return abstractUserDAO.insert(user);
	}
	
	public UsersVO getUser(String id) {
		return abstractUserDAO.findById(id).orElse(null);
	}
}