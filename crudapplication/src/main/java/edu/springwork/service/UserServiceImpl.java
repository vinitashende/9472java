package edu.springwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.springwork.entity.UserEntity;
import edu.springwork.exception.UserException;
import edu.springwork.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

//	UserServiceImpl(UserRepository userRepository) {
//		super();
//		this.userRepository = userRepository;
//	}

	@Override
	public UserEntity saveEntity(UserEntity params) {

		return userRepository.save(params);

	}

	@Override
	public List<UserEntity> getAllEntity() {

		return userRepository.findAll();
	}

	@Override
	public UserEntity getAnEntity(int id) {

		return userRepository.findById(id)
				.orElseThrow(() -> new UserException("User with id " + id + " Not Found!!!!!"));
	}

	@Override
	public UserEntity updateEntity(UserEntity params, int id) {

		UserEntity u = userRepository.findById(id).get();
		u.setEname(params.getEname());
		u.setEmail(params.getEmail());

		return userRepository.save(u);
	}

	@Override
	public String deleteEntity(int id) {

		userRepository.deleteById(id);
		return "User with id " + id + " has been deleted!!!!";
	}

}
