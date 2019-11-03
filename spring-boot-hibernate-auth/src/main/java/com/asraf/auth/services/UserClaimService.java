package com.asraf.auth.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.asraf.auth.entities.UserClaim;

public interface UserClaimService {

	UserClaim save(UserClaim userClaim);

	void delete(UserClaim userClaim);

	UserClaim getById(Long id);

	Iterable<UserClaim> getAll();

	List<UserClaim> getByUserId(long userId);

	Page<UserClaim> getByQuery(String search, Pageable pageable);

}
