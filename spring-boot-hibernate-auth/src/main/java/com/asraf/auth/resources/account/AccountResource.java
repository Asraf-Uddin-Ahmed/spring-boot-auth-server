package com.asraf.auth.resources.account;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpMethod;

import com.asraf.auth.controllers.AccountController;
import com.asraf.auth.controllers.MainController;
import com.asraf.auth.dtos.mapper.AccountUserMapper;
import com.asraf.auth.dtos.response.entities.UserResponseDto;
import com.asraf.auth.entities.User;
import com.asraf.auth.resources.BaseResource;
import com.asraf.auth.resources.ExtendedLink;
import com.asraf.auth.utils.HttpServletUtils;

import lombok.Getter;

@Getter
public class AccountResource extends BaseResource {

	private final UserResponseDto user;

	public AccountResource(final User user, final AccountUserMapper accountUserMapper)
			throws UnsupportedEncodingException, MessagingException {

		this.user = accountUserMapper.getResponseDto(user);
		final long id = user.getId();

		add(new ExtendedLink(linkTo(methodOn(AccountController.class).createUser(null)).withSelfRel())
				.withMethod(HttpMethod.POST));
		add(new ExtendedLink(linkTo(methodOn(AccountController.class).updateUser(id, null)).withSelfRel())
				.withMethod(HttpMethod.PUT));
		add(new ExtendedLink(linkTo(methodOn(AccountController.class).forgotPassword(null)).withSelfRel())
				.withMethod(HttpMethod.POST));
		add(new ExtendedLink(linkTo(methodOn(AccountController.class).getRequests()).withRel("requests"))
				.withMethod(HttpMethod.GET));

		String baseUrl = HttpServletUtils.getBaseUrl();
		add(new ExtendedLink(new Link(baseUrl + "/oauth/token").withRel("token")).withMethod(HttpMethod.GET)
				.withNullFormatAndFields());
		add(new ExtendedLink(new Link(baseUrl + "/oauth/authorize").withRel("auth-url")).withNullFormatAndFields());
		add(new ExtendedLink(new Link(baseUrl).withRel("root")).withMethod(HttpMethod.GET).withNullFormatAndFields());
		add(new ExtendedLink(
				linkTo(methodOn(MainController.class).getAuthenticatedLinks()).withRel("authenticated-links"))
						.withMethod(HttpMethod.GET).withNullFormatAndFields());

	}

}