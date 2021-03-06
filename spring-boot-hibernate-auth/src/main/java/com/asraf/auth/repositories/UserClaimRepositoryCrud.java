package com.asraf.auth.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.asraf.auth.entities.UserClaim;

@Transactional
public interface UserClaimRepositoryCrud extends PagingAndSortingRepository<UserClaim, Long> {
	List<UserClaim> findByUserId(long userId);
}
