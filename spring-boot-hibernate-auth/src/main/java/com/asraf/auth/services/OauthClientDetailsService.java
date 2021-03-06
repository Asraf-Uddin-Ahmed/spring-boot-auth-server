package com.asraf.auth.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.asraf.auth.entities.OauthClientDetails;

public interface OauthClientDetailsService {

	OauthClientDetails save(OauthClientDetails oauthClientDetails);

	void delete(OauthClientDetails oauthClientDetails);

	OauthClientDetails getById(String id);

	Iterable<OauthClientDetails> getAll();

	Page<OauthClientDetails> getByQuery(String search, Pageable pageable);

}
