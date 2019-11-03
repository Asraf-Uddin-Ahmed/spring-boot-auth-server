package com.asraf.auth.resources.assemblers.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asraf.auth.controllers.UserClaimController;
import com.asraf.auth.dtos.mapper.UserClaimMapper;
import com.asraf.auth.entities.UserClaim;
import com.asraf.auth.resources.assemblers.BaseResourceAssembler;
import com.asraf.auth.resources.entities.UserClaimResource;

@Component
public class UserClaimResourceAssembler extends BaseResourceAssembler<UserClaim, UserClaimResource> {

	private final UserClaimMapper userClaimMapper;

	@Autowired
	public UserClaimResourceAssembler(UserClaimMapper userClaimMapper) {
		super(UserClaimController.class, UserClaimResource.class);
		this.userClaimMapper = userClaimMapper;
	}

	@Override
	public UserClaimResource toResource(UserClaim entity) {
		return new UserClaimResource(entity, userClaimMapper);
	}

}