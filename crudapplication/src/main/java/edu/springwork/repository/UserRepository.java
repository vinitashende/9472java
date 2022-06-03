package edu.springwork.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.springwork.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	List<UserEntity> findByEmail(String email);

}
