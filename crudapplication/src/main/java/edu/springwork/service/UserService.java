package edu.springwork.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.springwork.entity.UserEntity;

@Component
public interface UserService {

	UserEntity saveEntity(UserEntity params);

	List<UserEntity> getAllEntity();

	UserEntity getAnEntity(int id);

	UserEntity updateEntity(UserEntity params, int id);

	String deleteEntity(int id);

}
