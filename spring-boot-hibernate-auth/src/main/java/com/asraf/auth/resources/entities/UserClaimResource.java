package com.asraf.auth.resources.entities;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.http.HttpMethod;

import com.asraf.auth.controllers.UserClaimController;
import com.asraf.auth.controllers.UserController;
import com.asraf.auth.dtos.mapper.UserClaimMapper;
import com.asraf.auth.dtos.response.entities.UserClaimResponseDto;
import com.asraf.auth.entities.User;
import com.asraf.auth.entities.UserClaim;
import com.asraf.auth.resources.BaseResource;
import com.asraf.auth.resources.ExtendedLink;

import lombok.Getter;

@Getter
public class UserClaimResource extends BaseResource {

	private final UserClaimResponseDto userClaim;

	public UserClaimResource(final UserClaim userClaim, final UserClaimMapper userClaimMapper) {

		this.userClaim = userClaimMapper.getResponseDto(userClaim);
		final long id = userClaim.getId();
		final User user = userClaim.getUser();

		add(new ExtendedLink(linkTo(methodOn(UserClaimController.class).getById(id)).withSelfRel())
				.withMethod(HttpMethod.GET));
		add(new ExtendedLink(linkTo(methodOn(UserClaimController.class).update(id, null)).withSelfRel())
				.withMethod(HttpMethod.PUT));
		add(new ExtendedLink(linkTo(methodOn(UserClaimController.class).delete(id)).withSelfRel())
				.withMethod(HttpMethod.DELETE));
		add(new ExtendedLink(linkTo(UserClaimController.class).withRel("user-claims")).withMethod(HttpMethod.GET));
		add(new ExtendedLink(linkTo(methodOn(UserController.class).getByEmail(user.getEmail())).withRel("user"))
				.withMethod(HttpMethod.GET));
		// add(new
		// ExtendedLink(linkTo(methodOn(UserController.class).getByName(user.getUsername())).withRel("user"))
		// .withMethod(HttpMethod.GET));
		add(new ExtendedLink(
				linkTo(methodOn(UserController.class).getByQuery("id==" + user.getId(), null, null)).withRel("user"))
						.withMethod(HttpMethod.GET));

		this.loadCommonLink();

	}

	public UserClaimResource forDeletion() {
		super.removeLinks();
		this.loadCommonLink();
		return this;
	}

	private void loadCommonLink() {
		add(new ExtendedLink(linkTo(methodOn(UserClaimController.class).create(null)).withRel("create"))
				.withMethod(HttpMethod.POST));
		add(new ExtendedLink(linkTo(methodOn(UserClaimController.class).getRequests()).withRel("requests"))
				.withMethod(HttpMethod.GET));
		add(new ExtendedLink(linkTo(UserClaimController.class).withRel("user-claims")).withMethod(HttpMethod.GET)
				.withSearchableData());
		add(new ExtendedLink(linkTo(methodOn(UserController.class).getByQuery(null, null, null)).withRel("users"))
				.withMethod(HttpMethod.GET).withSearchableData());
	}
}