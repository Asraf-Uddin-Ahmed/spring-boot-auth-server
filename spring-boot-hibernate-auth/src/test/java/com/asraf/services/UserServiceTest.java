package com.asraf.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.util.Date;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.asraf.entities.User;
import com.asraf.repositories.UserRepository;
import com.asraf.services.persistence.UserServiceImpl;

@RunWith(SpringRunner.class)
public class UserServiceTest {

	private static final String USERNAME = UUID.randomUUID().toString();

	private static UserRepository userRepository;

	@TestConfiguration
	static class UserServiceTestContextConfiguration {
		@Bean
		public UserService userService() {
			userRepository = mock(UserRepository.class);
			return new UserServiceImpl(userRepository);
		}
	}

	@Before
	public void setUp() {
		User ratul = new User(USERNAME, USERNAME + "@ratul.com", "password", "status", new Date(), new Date());
		Mockito.when(userRepository.findByUsername(ratul.getUsername())).thenReturn(ratul);
	}

	@Autowired
	private UserService userService;

	@Test
	public void whenValidUsername_thenUserShouldBeFound() {
		User found = userService.getByUsername(USERNAME);
		assertThat(found.getUsername()).isEqualTo(USERNAME);
	}

}
