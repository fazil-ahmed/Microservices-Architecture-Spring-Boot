package com.UmmahsKitchen.UserService.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.UmmahsKitchen.UserService.VO.UsersVO;


@Repository
public interface AbstractUserDAO extends MongoRepository<UsersVO, String> {

}