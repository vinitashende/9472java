package edu.springwork;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import edu.springwork.entity.UserEntity;
import edu.springwork.repository.UserRepository;

@DataJpaTest
public class JPATest {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	UserRepository userRepository;

	@Test
	void should_find_no_user_if_repository_is_empty() {
		Iterable<UserEntity> userEntity = userRepository.findAll();
		assertThat(userEntity).isEmpty();

	}

	@Test
	void should_store_an_user() {
		UserEntity u = userRepository.save(new UserEntity("a", "a@gmail.com"));
		assertThat(u).hasFieldOrPropertyWithValue("ename", "a");
		assertThat(u).hasFieldOrPropertyWithValue("email", "a@gmail.com");

	}

	@Test
	void should_find_all_user() {
		UserEntity u = new UserEntity("abc", "a@gmail.com");
		testEntityManager.persist(u);
		UserEntity u1 = new UserEntity("pqr", "b@gmail.com");
		testEntityManager.persist(u1);
		UserEntity u2 = new UserEntity("mno", "c@gmail.com");
		testEntityManager.persist(u2);

		Iterable<UserEntity> us = userRepository.findAll();
		assertThat(us).hasSize(3).contains(u, u1, u2);

	}

	@Test
	void should_find_user_by_email() {
		UserEntity u = new UserEntity("abc", "a@gmail.com");
		testEntityManager.persist(u);

		Iterable<UserEntity> us = userRepository.findByEmail("a@gmail.com");
		assertThat(us).hasSize(1).contains(u);
	}

	@Test
	void should_update_user() {
		UserEntity u = new UserEntity("abc", "a@gmail.com");
		testEntityManager.persist(u);
		UserEntity updated = new UserEntity("amitava", "abc@hotmail.com");
		UserEntity k = userRepository.findById(u.getId()).get();
		k.setEname(updated.getEname());
		k.setEmail(updated.getEmail());
		userRepository.save(k);
		UserEntity kupdated = userRepository.findById(u.getId()).get();
		assertThat(kupdated.getEname()).isEqualTo(updated.getEname());
		assertThat(kupdated.getEmail()).isEqualTo(updated.getEmail());

	}

	@Test
	void should_delete_user() {
		UserEntity u = new UserEntity("abc", "a@gmail.com");
		testEntityManager.persist(u);
		userRepository.deleteById(u.getId());
		assertThat(userRepository.findAll().isEmpty());
	}

}
