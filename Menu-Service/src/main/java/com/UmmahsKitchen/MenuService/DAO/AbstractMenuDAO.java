package com.UmmahsKitchen.MenuService.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.UmmahsKitchen.MenuService.VO.MenuItemsVO;


@Repository
public interface AbstractMenuDAO extends MongoRepository<MenuItemsVO, String>{

}
