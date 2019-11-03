package com.asraf.auth.services.persistence;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asraf.auth.entities.UserVerification;
import com.asraf.auth.repositories.UserVerificationRepository;
import com.asraf.auth.rsql.CustomRsqlVisitor;
import com.asraf.auth.services.UserVerificationService;
import com.asraf.auth.utils.ExceptionPreconditions;
import com.asraf.auth.utils.StringUtils;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;

@Service
@Transactional
public class UserVerificationServiceImpl implements UserVerificationService {

	private UserVerificationRepository userVerificationRepository;

	@Autowired
	public UserVerificationServiceImpl(UserVerificationRepository userVerificationRepository) {
		this.userVerificationRepository = userVerificationRepository;
	}

	public UserVerification save(UserVerification userVerification) {
		return userVerificationRepository.save(userVerification);
	}

	public void delete(UserVerification userVerification) {
		userVerificationRepository.delete(userVerification);
	}

	public void deleteByUserId(long userId) {
		userVerificationRepository.deleteByUserId(userId);
	}

	public UserVerification getById(Long id) {
		try {
			return userVerificationRepository.findById(id).get();
		} catch (NoSuchElementException nseex) {
			return ExceptionPreconditions.entityNotFound(UserVerification.class, "id", id.toString());
		}
	}

	public UserVerification getByVerificationCode(String verificationCode) {
		UserVerification userVerification = userVerificationRepository.findByVerificationCode(verificationCode);
		ExceptionPreconditions.checkFound(userVerification, UserVerification.class, "verificationCode",
				verificationCode.toString());
		return userVerification;
	}

	public Iterable<UserVerification> getAll() {
		return userVerificationRepository.findAll();
	}

	public Page<UserVerification> getByQuery(String search, Pageable pageable) {
		if (StringUtils.isNullOrEmpty(search))
			return userVerificationRepository.findAll(pageable);
		Node rootNode = new RSQLParser().parse(search);
		Specification<UserVerification> spec = rootNode.accept(new CustomRsqlVisitor<UserVerification>());
		Page<UserVerification> userVerification = userVerificationRepository.findAll(spec, pageable);
		return userVerification;
	}

}
