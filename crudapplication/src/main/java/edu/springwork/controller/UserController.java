package edu.springwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.springwork.entity.UserEntity;
import edu.springwork.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/save")
	public UserEntity saveUser(@RequestBody UserEntity params) {
		return userService.saveEntity(params);

	}

	@GetMapping(value = "/getall")
	public List<UserEntity> get() {
		return userService.getAllEntity();

	}

	@GetMapping(value = "/user/{id}")
	public UserEntity getAnEntity(@PathVariable int id) {
		return userService.getAnEntity(id);

	}

	@PutMapping(value = "/user/{id}")
	public UserEntity updateAnEntity(@PathVariable int id, @RequestBody UserEntity params) {

		return userService.updateEntity(params, id);

	}

	@DeleteMapping(value = "/user/{id}")
	public String deleteAnEntity(@PathVariable int id) {

		return userService.deleteEntity(id);

	}

}
