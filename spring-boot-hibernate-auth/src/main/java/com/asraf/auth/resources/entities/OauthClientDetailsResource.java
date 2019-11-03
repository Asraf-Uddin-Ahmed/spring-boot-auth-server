package com.asraf.auth.resources.entities;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.http.HttpMethod;

import com.asraf.auth.controllers.OauthClientDetailsController;
import com.asraf.auth.dtos.mapper.OauthClientDetailsMapper;
import com.asraf.auth.dtos.response.entities.OauthClientDetailsResponseDto;
import com.asraf.auth.entities.OauthClientDetails;
import com.asraf.auth.resources.BaseResource;
import com.asraf.auth.resources.ExtendedLink;

import lombok.Getter;

@Getter
public class OauthClientDetailsResource extends BaseResource {

	private final OauthClientDetailsResponseDto oauthClientDetails;

	public OauthClientDetailsResource(final OauthClientDetails oauthClientDetails,
			final OauthClientDetailsMapper oauthClientDetailsMapper) {

		this.oauthClientDetails = oauthClientDetailsMapper.getResponseDto(oauthClientDetails);
		final String id = oauthClientDetails.getClientId();

		add(new ExtendedLink(linkTo(methodOn(OauthClientDetailsController.class).getById(id)).withSelfRel())
				.withMethod(HttpMethod.GET));
		add(new ExtendedLink(linkTo(methodOn(OauthClientDetailsController.class).update(id, null)).withSelfRel())
				.withMethod(HttpMethod.PUT));
		add(new ExtendedLink(linkTo(methodOn(OauthClientDetailsController.class).delete(id)).withSelfRel())
				.withMethod(HttpMethod.DELETE));
		add(new ExtendedLink(linkTo(OauthClientDetailsController.class).withRel("oauth-clients"))
				.withMethod(HttpMethod.GET));

		this.loadCommonLink();

	}

	public OauthClientDetailsResource forDeletion() {
		super.removeLinks();
		this.loadCommonLink();
		return this;
	}

	private void loadCommonLink() {
		add(new ExtendedLink(linkTo(methodOn(OauthClientDetailsController.class).create(null)).withRel("create"))
				.withMethod(HttpMethod.POST));
		add(new ExtendedLink(linkTo(methodOn(OauthClientDetailsController.class).getRequests()).withRel("requests"))
				.withMethod(HttpMethod.GET));
		add(new ExtendedLink(linkTo(OauthClientDetailsController.class).withRel("oauth-clients"))
				.withMethod(HttpMethod.GET).withSearchableData());
	}
}