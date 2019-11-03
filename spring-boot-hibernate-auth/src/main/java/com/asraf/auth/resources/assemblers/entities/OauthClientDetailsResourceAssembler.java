package com.asraf.auth.resources.assemblers.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asraf.auth.controllers.OauthClientDetailsController;
import com.asraf.auth.dtos.mapper.OauthClientDetailsMapper;
import com.asraf.auth.entities.OauthClientDetails;
import com.asraf.auth.resources.assemblers.BaseResourceAssembler;
import com.asraf.auth.resources.entities.OauthClientDetailsResource;

@Component
public class OauthClientDetailsResourceAssembler extends BaseResourceAssembler<OauthClientDetails, OauthClientDetailsResource> {

	private final OauthClientDetailsMapper oauthClientDetailsMapper;

	@Autowired
	public OauthClientDetailsResourceAssembler(OauthClientDetailsMapper oauthClientDetailsMapper) {
		super(OauthClientDetailsController.class, OauthClientDetailsResource.class);
		this.oauthClientDetailsMapper = oauthClientDetailsMapper;
	}

	@Override
	public OauthClientDetailsResource toResource(OauthClientDetails entity) {
		return new OauthClientDetailsResource(entity, oauthClientDetailsMapper);
	}

}