package com.asraf.auth.services.persistence;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asraf.auth.entities.UserClaim;
import com.asraf.auth.repositories.UserClaimRepository;
import com.asraf.auth.rsql.CustomRsqlVisitor;
import com.asraf.auth.services.UserClaimService;
import com.asraf.auth.utils.ExceptionPreconditions;
import com.asraf.auth.utils.StringUtils;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;

@Service
@Transactional
public class UserClaimServiceImpl implements UserClaimService {

	private UserClaimRepository userClaimRepository;

	@Autowired
	public UserClaimServiceImpl(UserClaimRepository userClaimRepository) {
		this.userClaimRepository = userClaimRepository;
	}

	public UserClaim save(UserClaim userClaim) {
		return userClaimRepository.save(userClaim);
	}

	public void delete(UserClaim userClaim) {
		userClaimRepository.delete(userClaim);
	}

	public UserClaim getById(Long id) {
		try {
			return userClaimRepository.findById(id).get();
		} catch (NoSuchElementException nseex) {
			return ExceptionPreconditions.entityNotFound(UserClaim.class, "id", id.toString());
		}
	}

	public Iterable<UserClaim> getAll() {
		return userClaimRepository.findAll();
	}

	public List<UserClaim> getByUserId(long userId) {
		return userClaimRepository.findByUserId(userId);
	}

	public Page<UserClaim> getByQuery(String search, Pageable pageable) {
		if (StringUtils.isNullOrEmpty(search))
			return userClaimRepository.findAll(pageable);
		Node rootNode = new RSQLParser().parse(search);
		Specification<UserClaim> spec = rootNode.accept(new CustomRsqlVisitor<UserClaim>());
		Page<UserClaim> userClaims = userClaimRepository.findAll(spec, pageable);
		return userClaims;
	}

}
