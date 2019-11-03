package com.asraf.auth.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.asraf.auth.entities.UserVerification;

@Transactional
public interface UserVerificationRepositoryCrud extends PagingAndSortingRepository<UserVerification, Long> {

	public UserVerification findByVerificationCode(String verificationCode);
	
	public void deleteByUserId(long userId);
	
}
