package com.asraf.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.asraf.entities.User;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository userRepository;

	@Test
	public void whenFindByUsername_thenReturnUser() {
		// given
		final String USERNAME = UUID.randomUUID().toString();
		User ratul = new User(USERNAME, USERNAME + "@ratul.com", "password", "status", new Date(), new Date());
		entityManager.persist(ratul);
		entityManager.flush();

		// when
		User found = userRepository.findByUsername(ratul.getUsername());

		// then
		assertThat(found.getUsername()).isEqualTo(ratul.getUsername());
	}

}
