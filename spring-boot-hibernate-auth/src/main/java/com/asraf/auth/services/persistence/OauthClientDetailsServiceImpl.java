package com.asraf.auth.services.persistence;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asraf.auth.entities.OauthClientDetails;
import com.asraf.auth.repositories.OauthClientDetailsRepository;
import com.asraf.auth.rsql.CustomRsqlVisitor;
import com.asraf.auth.services.OauthClientDetailsService;
import com.asraf.auth.utils.ExceptionPreconditions;
import com.asraf.auth.utils.StringUtils;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;

@Service
@Transactional
public class OauthClientDetailsServiceImpl implements OauthClientDetailsService {

	private OauthClientDetailsRepository oauthClientDetailsRepository;

	@Autowired
	public OauthClientDetailsServiceImpl(OauthClientDetailsRepository oauthClientDetailsRepository) {
		this.oauthClientDetailsRepository = oauthClientDetailsRepository;
	}

	public OauthClientDetails save(OauthClientDetails oauthClientDetails) {
		return oauthClientDetailsRepository.save(oauthClientDetails);
	}

	public void delete(OauthClientDetails oauthClientDetails) {
		oauthClientDetailsRepository.delete(oauthClientDetails);
	}

	public OauthClientDetails getById(String id) {
		try {
			return oauthClientDetailsRepository.findByClientId(id);
		} catch (NoSuchElementException nseex) {
			return ExceptionPreconditions.entityNotFound(OauthClientDetails.class, "id", id.toString());
		}
	}

	public Iterable<OauthClientDetails> getAll() {
		return oauthClientDetailsRepository.findAll();
	}

	public Page<OauthClientDetails> getByQuery(String search, Pageable pageable) {
		if (StringUtils.isNullOrEmpty(search))
			return oauthClientDetailsRepository.findAll(pageable);
		Node rootNode = new RSQLParser().parse(search);
		Specification<OauthClientDetails> spec = rootNode.accept(new CustomRsqlVisitor<OauthClientDetails>());
		Page<OauthClientDetails> oauthClientDetailss = oauthClientDetailsRepository.findAll(spec, pageable);
		return oauthClientDetailss;
	}

}
