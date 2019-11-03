package com.asraf.auth.resources.main;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpMethod;

import com.asraf.auth.controllers.AccountController;
import com.asraf.auth.controllers.OauthClientDetailsController;
import com.asraf.auth.controllers.RoleController;
import com.asraf.auth.controllers.UserClaimController;
import com.asraf.auth.controllers.UserController;
import com.asraf.auth.controllers.UserVerificationController;
import com.asraf.auth.resources.BaseResource;
import com.asraf.auth.resources.ExtendedLink;
import com.asraf.auth.utils.HttpServletUtils;

public class MainAuthenticatedResource extends BaseResource {

	public MainAuthenticatedResource() {

		add(new ExtendedLink(linkTo(AccountController.class).withRel("accounts")).withMethod(HttpMethod.GET)
				.withSearchableData());

		add(new ExtendedLink(linkTo(UserController.class).withRel("users")).withMethod(HttpMethod.GET)
				.withSearchableData());

		add(new ExtendedLink(linkTo(UserVerificationController.class).withRel("user-verifications"))
				.withMethod(HttpMethod.GET).withSearchableData());

		add(new ExtendedLink(linkTo(UserClaimController.class).withRel("user-claims")).withMethod(HttpMethod.GET)
				.withSearchableData());

		add(new ExtendedLink(linkTo(RoleController.class).withRel("roles")).withMethod(HttpMethod.GET)
				.withSearchableData());

		add(new ExtendedLink(linkTo(OauthClientDetailsController.class).withRel("oauth-clients"))
				.withMethod(HttpMethod.GET).withSearchableData());

		String baseUrl = HttpServletUtils.getBaseUrl();
		add(new ExtendedLink(new Link(baseUrl + "/oauth/token").withRel("token")).withMethod(HttpMethod.GET));

	}

}