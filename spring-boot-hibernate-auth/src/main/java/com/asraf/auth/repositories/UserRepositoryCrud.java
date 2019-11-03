package com.asraf.auth.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.asraf.auth.entities.User;

@Transactional
public interface UserRepositoryCrud extends PagingAndSortingRepository<User, Long> {

	public User findByEmail(String email);

	public User findByUsername(String username);

	@Query("select u from User u where u.username like %?1% order by username")
	List<User> findByUsernameContains(String username);

	List<User> findByUsernameOrEmail(String username, String email);

	Page<User> findByUsernameContainsOrEmailContainsAllIgnoreCase(String username, String email, Pageable pageRequest);

	// @Query("SELECT t FROM Todo t WHERE " + "LOWER(t.title) LIKE
	// LOWER(CONCAT('%',:searchTerm, '%')) OR "
	// + "LOWER(t.description) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
	// List<Todo> findBySearchTerm(@Param("searchTerm") String searchTerm, Pageable
	// pageRequest);

}
