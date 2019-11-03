package com.asraf.auth.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.asraf.auth.entities.OauthClientDetails;

@Transactional
public interface OauthClientDetailsRepositoryCrud extends PagingAndSortingRepository<OauthClientDetails, Long> {
	
	public OauthClientDetails findByClientId(String id);

}
