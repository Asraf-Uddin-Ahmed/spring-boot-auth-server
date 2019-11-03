package com.asraf.auth.resources.entities;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.http.HttpMethod;

import com.asraf.auth.controllers.RoleController;
import com.asraf.auth.controllers.UserController;
import com.asraf.auth.dtos.mapper.RoleMapper;
import com.asraf.auth.dtos.response.entities.RoleResponseDto;
import com.asraf.auth.entities.Role;
import com.asraf.auth.resources.BaseResource;
import com.asraf.auth.resources.ExtendedLink;

import lombok.Getter;

@Getter
public class RoleResource extends BaseResource {

	private final RoleResponseDto role;

	public RoleResource(final Role role, final RoleMapper roleMapper) {

		this.role = roleMapper.getResponseDto(role);
		final long id = role.getId();

		add(new ExtendedLink(linkTo(methodOn(RoleController.class).getById(id)).withSelfRel())
				.withMethod(HttpMethod.GET));
		add(new ExtendedLink(linkTo(methodOn(RoleController.class).update(id, null)).withSelfRel())
				.withMethod(HttpMethod.PUT));
		add(new ExtendedLink(linkTo(methodOn(RoleController.class).delete(id)).withSelfRel())
				.withMethod(HttpMethod.DELETE));
		add(new ExtendedLink(linkTo(RoleController.class).withRel("roles")).withMethod(HttpMethod.GET));

		this.loadCommonLink();

	}

	public RoleResource forDeletion() {
		super.removeLinks();
		this.loadCommonLink();
		return this;
	}

	private void loadCommonLink() {
		add(new ExtendedLink(linkTo(methodOn(RoleController.class).create(null)).withRel("create"))
				.withMethod(HttpMethod.POST));
		add(new ExtendedLink(linkTo(methodOn(RoleController.class).getRequests()).withRel("requests"))
				.withMethod(HttpMethod.GET));
		add(new ExtendedLink(linkTo(RoleController.class).withRel("roles")).withMethod(HttpMethod.GET)
				.withSearchableData());
		add(new ExtendedLink(linkTo(methodOn(UserController.class).getByQuery(null, null, null)).withRel("users"))
				.withMethod(HttpMethod.GET).withSearchableData());
	}
}